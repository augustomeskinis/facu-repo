package patrones.ej19fileManager;

public class DecoratorNombre extends FileDecorator {
    public DecoratorNombre(File file) {
        super(file);
    }

    @Override
    public String prettyPrint() {
        String base = super.prettyPrint();
        return (base.isEmpty() ? "" : base + " - ") + ((FileOO2)file).getNombre();
    }
}
