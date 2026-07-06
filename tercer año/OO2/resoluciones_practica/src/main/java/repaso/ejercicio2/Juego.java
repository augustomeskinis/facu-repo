package repaso.ejercicio2;

public class Juego {
    private Piedra piedra;
    private Papel papel;
    private Tijera tijera;
    private Lagarto lagarto;
    private Spock spock;

    public Juego (){
        this.piedra = new Piedra();
        this.papel = new Papel();
        this.tijera = new Tijera();
        this.lagarto = new Lagarto();
        this.spock = new Spock();

    }

    public void jugar(String objeto1, String objeto2){
        switch (objeto1) {
            case "piedra":
                piedra.jugar(objeto2);
                break;
            case "papel":
                papel.jugar(objeto2);
                break;
            case "tijera":
                tijera.jugar(objeto2);
                break;
            case "lagarto":
                lagarto.jugar(objeto2);
            case "spock":
                spock.jugar(objeto2);
        }
    }

    public static void main (String [] args){
        Juego juego = new Juego();
        juego.jugar("piedra","papel");
        juego.jugar("papel","piedra");
    }
}
