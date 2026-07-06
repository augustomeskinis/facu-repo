package patrones.ej16excursion;

public class conCupoMaximo extends State {

    public conCupoMaximo (Excursion excursion){
        super(excursion);
    }

    @Override
    public void inscribir(Usuario usuario) {
        System.out.println("error, se alcanzó el cupo máximo");
    }


}
