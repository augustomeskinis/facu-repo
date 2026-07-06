package repasoTest;

import org.junit.jupiter.api.Test;
import repaso.ejercicio1.Tweet;
import repaso.ejercicio1.Usuario;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwitterTest {
    @Test
    void tweet_getTexto_devuelveTextoCorrectamente() {
        Tweet tweet = new Tweet("Hola mundo!");
        assertEquals("Hola mundo!", tweet.getTexto());
    }

    @Test
    void tweet_conOrigen_getTextoDevuelveTextoDelRetweet() {
        Tweet original = new Tweet("Tweet original");
        Tweet retweet = new Tweet("RT: Tweet original", original);
        assertEquals("RT: Tweet original", retweet.getTexto());
    }

    @Test
    void usuario_getScreenName_devuelveScreenNameCorrectamente() {
        Usuario usuario = new Usuario("juan123");
        assertEquals("juan123", usuario.getScreenName());
    }
}
