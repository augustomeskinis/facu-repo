package repaso.ejercicio2;

public class Piedra extends Objeto{

    public Piedra(){
        super("piedra");
    }

    @Override
    public void jugar(String objeto) {
        if(objeto.equals("tijera") | objeto.equals("spock")){
            System.out.println("gana piedra!");
        }

        else if (objeto.equals(this.getNombre())) {
            System.out.println("empate");
        }

        else {
            System.out.println("gana " + objeto);
        }
    }
}
