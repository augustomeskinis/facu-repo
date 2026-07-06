package patrones.ej19fileManager;

public class DecoratorFechaCreacion extends FileDecorator {
    public DecoratorFechaCreacion(File file) {
        super(file);
    }

    @Override
    public String prettyPrint() {
        String base = super.prettyPrint();
        return (base.isEmpty() ? "" : base + " - ") + ((FileOO2)file).getFechaCreacion();
    }
}
