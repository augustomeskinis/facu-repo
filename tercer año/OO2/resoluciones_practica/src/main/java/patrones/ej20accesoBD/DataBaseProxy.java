package patrones.ej20accesoBD;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class DataBaseProxy implements DatabaseAccess {
    private List<Usuario> usuariosAutenticados;
    private DatabaseAccess database;

    public DataBaseProxy (DatabaseAccess databaseAccess){
        this.usuariosAutenticados=new LinkedList<>();
        this.database=databaseAccess;
    }

    public void registrarse(Usuario usuario){
        this.usuariosAutenticados.add(usuario);
    }

    public boolean autenticar(String nombre, String contrasenia) {
        for (Usuario usuario : usuariosAutenticados) {
            if (usuario.getNombre().equals(nombre) &&
                    usuario.validarContraseña(contrasenia)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int insertNewRow(List<String> rowData) {
        if (usuariosAutenticados.isEmpty()) {
            throw new SecurityException("Usuario no autenticado.");
        }
        return database.insertNewRow(rowData);
    }

    @Override
    public Collection<String> getSearchResults(String queryString) {
        if (usuariosAutenticados.isEmpty()) {
            throw new SecurityException("Usuario no autenticado.");
        }
        return database.getSearchResults(queryString);
    }

}
