package repaso.ejercicio2;

public class Spock extends Objeto {
    public Spock(){
        super("spock");
    }

    public void jugar(String objeto) {
        if(objeto.equals("tijera") | objeto.equals("piedra")){
            System.out.println("gana spock!");
        }

        else if (objeto.equals(this.getNombre())) {
            System.out.println("empate");
        }

        else {
            System.out.println("gana " + objeto);
        }
    }

}
