package patrones.ej14armadoDePCs;

import java.util.LinkedList;
import java.util.List;

public class Catalogo {
    private List<Componente> componentes;


    public Catalogo (){
        this.componentes = new LinkedList<>();
        this.addComponente(new Componente("ryzen 5", "procesador basico", 500, 1));
        this.addComponente(new Componente("KIGSTON","8 gb",800,1 ));


    }

    public void addComponente(Componente c){
        this.componentes.add(c);
    }

    public Componente getComponente(String d){
        return this.componentes.stream()
                    .filter(componente -> componente.getDescripcion().equals(d))
                    .findFirst()
                    .orElse(null);
    }

}
