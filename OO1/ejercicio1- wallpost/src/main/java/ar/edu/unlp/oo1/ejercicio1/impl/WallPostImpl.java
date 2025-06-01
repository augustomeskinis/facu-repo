package ar.edu.unlp.oo1.ejercicio1.impl;

import ar.edu.unlp.oo1.ejercicio1.WallPost;

/**
 * Completar esta clase de acuerdo a lo especificado en el cuadernillo
 *
 */
public class WallPostImpl implements WallPost {
	private String text;
	private int likes;
	private boolean destacado;
	
	public WallPostImpl() {
		text = "Undefined Post";
		likes = 0;
		destacado = false;
	}
	
	public void like() {
		likes++;
	}
	public void dislike() {
		likes--;
	}
	
	public boolean isFeatured () {
		return destacado;
	}
	
	public void toggleFeatured() {
		if (this.destacado) {
			this.destacado = false;
		}
		else {
			this.destacado = true;
		}
	}
	
	public int getLikes() {
		return likes;
	}
	
	public String getText() {
		return text;
	}
	
	
	public void setText(String text) {
		this.text = text;
	}



	/**
	 * Complete con su implementación
	 */

	/*
	 * Este mensaje se utiliza para que una instancia de Wallpost se muestre de forma adecuada
	 */
    @Override
    public String toString() {
        return "WallPost {" +
            "text: " + getText() +
            ", likes: '" + getLikes() + "'" +
            ", featured: '" + isFeatured() + "'" +
            "}";
    }

}
