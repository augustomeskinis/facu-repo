package refactoring.ejercicio11;

public class ArbolBinarioSinREF {
    private int valor;
    private ArbolBinarioSinREF hijoIzquierdo;
    private ArbolBinarioSinREF hijoDerecho;

    public ArbolBinarioSinREF(int valor) {
        this.valor = valor;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public ArbolBinarioSinREF getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(ArbolBinarioSinREF hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public ArbolBinarioSinREF getHijoDerecho() {
        return hijoDerecho;
    }

    public void setDerecha(ArbolBinarioSinREF hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

   public String recorrerPreorden() {
        String resultado = valor + " - ";
        if (this.getHijoIzquierdo() != null) {
        	resultado += this.getHijoIzquierdo().recorrerPreorden();
	}
        if (this.getHijoDerecho() != null) {
        	resultado += this.getHijoDerecho().recorrerPreorden();
        }
        return resultado;
    }

   public String recorrerInorden() {
        String resultado = "";
        if (this.getHijoIzquierdo() != null) {
        	resultado += this.getHijoIzquierdo().recorrerInorden();
	}
        resultado += valor + " - ";
        if (this.getHijoDerecho() != null) {
        	resultado += this.getHijoDerecho().recorrerInorden();
        }
        return resultado;
    }

   public String recorrerPostorden() {
        String resultado = "";
        if (this.getHijoIzquierdo() != null) {
        	resultado += this.getHijoIzquierdo().recorrerPostorden();
	}
        if (this.getHijoDerecho() != null) {
        	resultado += this.getHijoDerecho().recorrerPostorden();
        }
        resultado += valor + " - ";
        return resultado;
    }

}

