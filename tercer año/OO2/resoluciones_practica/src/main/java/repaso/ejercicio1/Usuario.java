package repaso.ejercicio1;

import java.util.LinkedList;
import java.util.List;

public class Usuario {
    private String screenName;
    private List<Tweet> tweets;
    private List<Tweet> retweets;

    public Usuario(String screenName){
        this.screenName = screenName;
        this.tweets = new LinkedList<>();    // ← faltaba esto
        this.retweets = new LinkedList<>();  // ← faltaba esto
    }

    public String getScreenName(){
        return this.screenName;
    }

    public void crearTweet(String texto){
        if (!texto.isEmpty() && texto.length() <= 280){
            this.tweets.add(new Tweet (texto));
        }
        else{
            System.out.println("el texto tiene mas de 280 caracteres");
        }
    }

    public void retweetear (Tweet tweetOrigen){
        this.retweets.add(new Tweet(tweetOrigen.getTexto(),tweetOrigen));
    }

    public void eliminarTweets(){
        this.tweets=new LinkedList<>();
        this.retweets=new LinkedList<>();
    }
}
