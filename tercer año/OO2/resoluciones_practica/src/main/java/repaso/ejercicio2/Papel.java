package repaso.ejercicio2;

public class Papel extends Objeto {
    public Papel(){
        super("papel");
    }

    public void jugar(String objeto) {
        if(objeto.equals("piedra") | objeto.equals("spock")){
            System.out.println("gana papel!");
        } else if (objeto.equals(this.getNombre())) {
            System.out.println("empate");
        } else {
            System.out.println("gana " + objeto);
        }
    }



}
