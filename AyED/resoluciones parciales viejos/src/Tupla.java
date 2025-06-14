public class Tupla {
    private int cantUsuarios;
    private boolean esPopular;

    public Tupla (int cant, boolean es){
        this.cantUsuarios=cant;
        this.esPopular=es;
    }

    public int getCantUsuarios() {
        return cantUsuarios;
    }

    public void setCantUsuarios(int cantUsuarios) {
        this.cantUsuarios = cantUsuarios;
    }

    public boolean isEsPopular() {
        return esPopular;
    }

    public void setEsPopular(boolean esPopular) {
        this.esPopular = esPopular;
    }
}
