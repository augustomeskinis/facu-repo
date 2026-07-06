package patrones.ej18Personajes;

public abstract class Armadura {
    public abstract void recibirDano(Espada espada);
    public abstract void recibirDano(Arco arco);
    public abstract void recibirDano(BastonesDeMago baston);
    public abstract void recibirDano(Martillo martillo);
}
