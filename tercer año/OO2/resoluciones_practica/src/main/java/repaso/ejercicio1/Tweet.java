package repaso.ejercicio1;

public class Tweet {
    private String texto;
    private Tweet origen;

    public Tweet (String texto){
        this.texto=texto;
    }

    public Tweet (String texto, Tweet origen){
        this.texto=texto;
        this.origen=origen;
    }

    public String getTexto(){
        return this.texto;
    }

}
