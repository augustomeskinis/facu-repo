import ejercicio1.Edge;
import ejercicio1.Graph;
import ejercicio1.Vertex;

import java.util.LinkedList;
import java.util.List;

public class parcialCordo {
	public List<Integer> nivelPopularidad(Graph<String> red, String usuario, int distancia, int umbral){
		Vertex<String> verticeUsuario = red.search(usuario);
		List<Integer> tupla = new LinkedList<>();
		if (verticeUsuario!=null) {
			resolver(red,verticeUsuario,distancia,umbral,tupla);
		}else {
			tupla.add(0);
			tupla.add(0);
		}
		return tupla;
	}
	
	private void resolver(Graph<String> red, Vertex<String> verticeUsuario, int distancia, int umbral, List<Integer> tupla) {
		Queue<Vertex<String>> cola = new Queue<>();
		boolean[] visitados = new boolean[red.getSize()];
		
		visitados[verticeUsuario.getPosition()] = true;
		cola.enqueue(verticeUsuario);
		
		int nivel = 0;
		while ((!cola.isEmpty()) && (nivel<distancia)) {
			int cantUsuarios = cola.size();
			for (int i=0;i<cantUsuarios;i++) {
				Vertex<String> verticeDestino = cola.dequeue();
				
				for (Edge<String> e:red.getEdges(verticeDestino)) {
					if (!visitados[e.getTarget().getPosition()]) {
						visitados[e.getTarget().getPosition()] = true;
						cola.enqueue(e.getTarget());
					}
				}
			}
			nivel ++;
		}
		if (nivel == distancia) {
			int cantUsuarios = cola.size();
			tupla.add(cantUsuarios);
			if (cantUsuarios>=umbral) {
				tupla.add(1);
			}else{
				tupla.add(0);
			}
		}
	}
}