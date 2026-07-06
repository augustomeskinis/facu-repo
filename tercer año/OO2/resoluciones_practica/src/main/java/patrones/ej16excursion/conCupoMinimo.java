package patrones.ej16excursion;

public class conCupoMinimo extends State {

    public conCupoMinimo(Excursion excursion){
        super(excursion);
    }

    @Override
    public void inscribir(Usuario usuario) {
        excursion.addUsuario(usuario);
        if (excursion.getUsuariosInscriptos().size() == excursion.getCupoMaximo()){
            excursion.setState(new conCupoMaximo(excursion));
        }
    }

    @Override
    public String obtenerInformacion(){
        return super.obtenerInformacion() + " ,usuarios faltantes para el cupo maximo:"
                + ", mails inscriptos: " + excursion.mailsInscriptos()
                + (excursion.getCupoMaximo() - excursion.cantUsuariosInscriptos());
    }


}
