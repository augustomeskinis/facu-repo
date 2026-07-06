package patrones.ej19fileManager;

public abstract class FileDecorator implements File {
    protected File file;

    public FileDecorator(File file) {
        this.file = file;
    }

    @Override
    public String prettyPrint() {
        return file.prettyPrint();
    }
}
