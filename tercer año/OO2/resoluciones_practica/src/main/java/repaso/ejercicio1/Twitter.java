package repaso.ejercicio1;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Twitter {
    private List<Usuario> usuarios;

    public Twitter(){
        this.usuarios = new LinkedList<>();
    }

    public void agregarUsuario (String screenName){
        boolean yaExiste = usuarios.stream().anyMatch(u -> u.getScreenName().equals(screenName));
        if (!yaExiste){
            usuarios.add(new Usuario(screenName));
        }
        else {
            System.out.println("el screenName ya existe");
        }
    }

    public void eliminarUsuario(String screenName){
        Usuario usuario = usuarios.stream()
                .filter(u -> u.getScreenName().equals(screenName))
                .findFirst()
                .orElse(null);

        if (usuario != null) {
            usuario.eliminarTweets();
            this.usuarios.remove(usuario);
        }
    }

}
