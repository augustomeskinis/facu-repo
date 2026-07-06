package patrones.ej5elementosQuimicos;

import java.util.ArrayList;
import java.util.List;

public class Union extends ElementoQuimico {

    private List<ElementoQuimico> elementos = new ArrayList<>();

    public void addElemento(ElementoQuimico elementoQuimico){
        elementos.add(elementoQuimico);
    }

    public String formula() {
        String resultado = "";
        for (ElementoQuimico atomo : elementos) {
            resultado += atomo.formula();
        }
        return resultado;
    }

    public double pesoAtomico() {
        return this.elementos
                .stream()
                .mapToDouble(elementoQuimico -> elementoQuimico.pesoAtomico())
                .sum();
    }

    public double cargaElectrica() {
        return this.elementos
                .stream()
                .mapToDouble(elementoQuimico -> elementoQuimico.cargaElectrica())
                .sum();
    }

    public boolean esMetal() {
        return elementos.stream().anyMatch(e -> e.esMetal());
    }

    @Override
    public boolean esValida() {
        // Verificar que NO sea metal + metal
        return !hay2metales();
    }

    private boolean hay2metales() {
        long metales = elementos.stream()
                .filter(e -> e.esMetal())
                .count();
        return metales >= 2;
    }

}
