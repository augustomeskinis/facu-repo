package patrones.ej16excursion;

public class sinCupoMinimo extends State {

    public sinCupoMinimo (Excursion excursion){
        super(excursion);
    }

    @Override
    public void inscribir(Usuario usuario) {
        excursion.addUsuario(usuario);
        if (excursion.getUsuariosInscriptos().size() == excursion.getCupoMinimo()){
            excursion.setState(new conCupoMinimo(excursion));
        }
    }

    @Override
    public String obtenerInformacion(){
        return super.obtenerInformacion() + " ,usuarios faltantes para el cupo minimo: " +
                (excursion.getCupoMinimo() - excursion.cantUsuariosInscriptos());
    }
}
