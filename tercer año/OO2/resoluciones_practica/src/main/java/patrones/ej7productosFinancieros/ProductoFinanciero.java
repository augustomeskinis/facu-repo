package patrones.ej7productosFinancieros;

import java.time.LocalDate;

public abstract class ProductoFinanciero  {
    LocalDate fechaOperacion;

    public abstract double retornoInversion(double montoInicial);


}
