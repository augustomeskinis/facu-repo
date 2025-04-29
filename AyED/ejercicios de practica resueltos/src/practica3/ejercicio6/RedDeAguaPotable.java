package practica3.ejercicio6;

import practica3.ejercicio5.GeneralTree;

public class RedDeAguaPotable {
	GeneralTree<Character> arbol;
	
	public RedDeAguaPotable() {
		this.arbol = new GeneralTree<>();
		GeneralTree<Character>nodoA = new GeneralTree<>('A');
		GeneralTree<Character>nodoB = new GeneralTree<>('B');
		GeneralTree<Character>nodoC = new GeneralTree<>('C');
		GeneralTree<Character>nodoD = new GeneralTree<>('D');
		
		arbol.addChild(nodoA);
		arbol.addChild(nodoB);
		arbol.addChild(nodoC);
		arbol.addChild(nodoD);
		
		GeneralTree<Character>nodoE = new GeneralTree<>('E');
		GeneralTree<Character>nodoF = new GeneralTree<>('F');
		GeneralTree<Character>nodoG = new GeneralTree<>('G');
		GeneralTree<Character>nodoH = new GeneralTree<>('H');
		
		nodoA.addChild(nodoE);
		nodoA.addChild(nodoF);
		
		nodoB.addChild(nodoG);
		nodoB.addChild(nodoH);
		
		GeneralTree<Character>nodoI = new GeneralTree<>('I');
		GeneralTree<Character>nodoJ = new GeneralTree<>('I');
		nodoE.addChild(nodoI);
		nodoE.addChild(nodoJ);
	}
	
	private double calcularMinimo(GeneralTree<Character>arbol,double caudal, double minimo) {
		if (arbol.isLeaf()){
			minimo = caudal;
		}
		else {
			int cantHijos = arbol.getChildren().size();
			caudal /= cantHijos;
			for (GeneralTree<Character> child: arbol.getChildren()) {
				minimo = this.calcularMinimo(child, caudal, minimo);
			}
		}
		return minimo;
	}

	public double minimoCaudal(double caudal) {
		double minimo = 9999999; 
		return this.calcularMinimo(this.arbol,caudal,minimo);
	}
	
	public static void main (String []args) {
		RedDeAguaPotable red = new RedDeAguaPotable();
		System.out.println("minimo caudal "+red.minimoCaudal(1000));
	}

}
