package patrones.ej19fileManager;

public class DecoratorPermisos extends FileDecorator {
    public DecoratorPermisos(File file) {
        super(file);
    }

    @Override
    public String prettyPrint() {
        String base = super.prettyPrint();
        return (base.isEmpty() ? "" : base + " - ") + ((FileOO2)file).getPermisos();
    }
}
