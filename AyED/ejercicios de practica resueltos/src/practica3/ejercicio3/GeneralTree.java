package practica3.ejercicio3;
    import java.util.LinkedList;
    import java.util.List;
    import practica1.ejercicio8.Queue;

public class GeneralTree<T>{

        private T data;
        private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>();

        public GeneralTree() {

        }
        public GeneralTree(T data) {
            this.data = data;
        }

        public GeneralTree(T data, List<GeneralTree<T>> children) {
            this(data);
            this.children = children;
        }
        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public List<GeneralTree<T>> getChildren() {
            return this.children;
        }

        public void setChildren(List<GeneralTree<T>> children) {
            if (children != null)
                this.children = children;
        }

        public void addChild(GeneralTree<T> child) {
            this.getChildren().add(child);
        }

        public boolean isLeaf() {
            return !this.hasChildren();
        }

        public boolean hasChildren() {
            return !this.children.isEmpty();
        }

        public boolean isEmpty() {
            return this.data == null && !this.hasChildren();
        }

        public void removeChild(GeneralTree<T> child) {
            if (this.hasChildren())
                children.remove(child);
        }

        public int camino(int longitud, int max) {
        	if (this.hasChildren()) {
        		longitud++;
        		for (GeneralTree<T> child: this.children) {
        			child.camino(longitud,max);
        			if (longitud > max) {
        				max = longitud;
        			}
        	}
        	}
            return max;
        }
        
        public int altura() {
        	int max = -1; int longitud = 0;
        	return(this.camino(longitud, max));
        }



    public int nivel(T dato) {
        Queue<GeneralTree<T>> queue = new Queue<>();
        queue.enqueue(this);  // Empezamos desde la raíz (this)
        int nivel = 0;
        boolean encontre = false;

        while (!queue.isEmpty() && !encontre) {
            int size = queue.size();  // Cantidad de nodos en este nivel

            for (int i = 0; i < size && !encontre; i++) {
                GeneralTree<T> treeAux = queue.dequeue();
                if (dato.equals(treeAux.getData())) {
                    encontre = true;
                } else {
                    for (GeneralTree<T> child : treeAux.getChildren()) {
                        queue.enqueue(child);
                    }
                }
            }

            // Si no lo encontré en este nivel, subo de nivel
            if (!encontre) {
                nivel++;
            }
        }

        if (!encontre) {
            nivel = -1;
        }

        return nivel;
    }
    public int ancho() {
        Queue<GeneralTree<T>> queue = new Queue<>();
        queue.enqueue(this);  // Empezamos desde la raíz (this)
        int maxAncho = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();  // Cantidad de nodos en este nivel

            if (size > maxAncho) {
                maxAncho = size;
            }

            for (int i = 0; i < size; i++) {
                GeneralTree<T> treeAux = queue.dequeue();
                for (GeneralTree<T> child : treeAux.getChildren()) {
                    queue.enqueue(child);
                }
            }
        }

        return maxAncho;
    }
    }
