package patrones.ej19fileManager;

public class DecoratorExtension extends FileDecorator {
    public DecoratorExtension(File file) {
        super(file);
    }

    @Override
    public String prettyPrint() {
        String base = super.prettyPrint();
        return (base.isEmpty() ? "" : base + " - ") + ((FileOO2)file).getExtension();
    }
}
