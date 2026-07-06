package patrones.ej19fileManager;

public class DecoratorTamanio extends FileDecorator {
    public DecoratorTamanio(File file) {
        super(file);
    }

    @Override
    public String prettyPrint() {
        String base = super.prettyPrint();
        return (base.isEmpty() ? "" : base + " - ") + ((FileOO2)file).getTamanio() + "kb";
    }
}
