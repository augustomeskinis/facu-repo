package refactoring.ejercicio10.conRefactoring;

import java.util.List;

public class ClienteJuridico extends Cliente {
    private String CUIT;
    public ClienteJuridico(String nombre, String numeroTelefono, String CUIT) {
        super(nombre, numeroTelefono);
        this.CUIT=CUIT;
    }

    public double getDescuento() { return 0.15; }
}
