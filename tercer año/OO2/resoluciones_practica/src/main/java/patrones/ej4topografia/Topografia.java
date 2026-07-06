package patrones.ej4topografia;

import java.util.List;

public  class Topografia extends Componente { //una topografia es en realidad un componente mixto
    private List<Componente> componentes;

    public Topografia(List<Componente> componentes){
        if (componentes.size() == 4){
            this.componentes=componentes;
        }
        System.out.println("una topografia debe tener 4 componentes");
    }


    public double getProporcion(){
        double suma = this.componentes
                        .stream()
                        .mapToDouble(proporcion -> proporcion.getProporcion())
                        .sum();
        return suma/4;
    }

    public boolean esIgual(List<Componente> otraTopografia){
        return this.componentes.equals(otraTopografia);
    }

}
