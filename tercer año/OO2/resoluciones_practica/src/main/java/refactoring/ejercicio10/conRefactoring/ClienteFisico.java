package refactoring.ejercicio10.conRefactoring;

public class ClienteFisico extends Cliente {
    private String DNI;

    public ClienteFisico(String nombre, String numeroTelefono, String DNI) {
        super(nombre, numeroTelefono);
        this.DNI=DNI;
    }

    public double getDescuento() { return 0; }


}
