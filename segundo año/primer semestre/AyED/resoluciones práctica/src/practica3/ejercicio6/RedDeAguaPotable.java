package practica3.ejercicio6;

import practica3.ejercicio5.GeneralTree;

public class RedDeAguaPotable {
    GeneralTree<Character> arbol;

    public RedDeAguaPotable() {
        this.arbol = new GeneralTree<>();
    }

    private double calcularMinimo(GeneralTree<Character> arbol, double caudal) {
        // Si es una hoja (casa), retornamos el caudal actual
        if (arbol.isLeaf()) {
            return caudal;
        }

        // Si no es hoja, dividimos el caudal entre los hijos
        int cantHijos = arbol.getChildren().size();
        double caudalDividido = caudal / cantHijos;

        // Buscamos el mínimo entre todos los hijos recursivamente
        double minimo = Double.MAX_VALUE;
        for (GeneralTree<Character> child : arbol.getChildren()) {
            double minimoDelSubarbol = this.calcularMinimo(child, caudalDividido);
            minimo = Math.min(minimo, minimoDelSubarbol);
        }

        return minimo;
    }

    public double minimoCaudal(double caudal) {
        return this.calcularMinimo(this.arbol, caudal);
    }

    public static void main(String[] args) {
        RedDeAguaPotable red = new RedDeAguaPotable();
        System.out.println("minimo caudal: " + red.minimoCaudal(1000.0));
    }
}