package repaso.ejercicio2;

public class Tijera extends Objeto{
    public Tijera(){
        super("tijera");
    }

    public void jugar(String objeto) {
        if(objeto.equals("papel") | objeto.equals("lagarto")){
            System.out.println("gana tijera!");
        }

        else if (objeto.equals(this.getNombre())) {
            System.out.println("empate");
        }

        else {
            System.out.println("gana " + objeto);
        }
    }

}