package repaso.ejercicio2;

public class Lagarto extends Objeto {
    public Lagarto(){
        super("lagarto");
    }


    public void jugar(String objeto) {
        if(objeto.equals("papel") | objeto.equals("spock")){
            System.out.println("gana lagarto!");
        }

        else if (objeto.equals(this.getNombre())) {
            System.out.println("empate");
        }

        else {
            System.out.println("gana " + objeto);
        }
    }
}
