package ar.edu.unlp.info.oo1.ejercicio23_MercadoDeObjetos;
import java.util.AbstractCollection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BagImpl<T> extends AbstractCollection<T> implements Bag<T> {

    Map<T, Integer> elements;

    public BagImpl() {
        // TODO Completar con la instanciación adecuada
        // this.elements = ....
    	this.elements = new HashMap<T,Integer>();
    }

    @Override
    public boolean add(T element) {
        // TODO Completar con la implementación correspondiente
    	this.elements.put(element, this.elements.getOrDefault(element, 0) + 1);
        return true;
    }

    @Override
    public int occurrencesOf(T element) {
        // TODO Completar con la implementación correspondiente
        return this.elements.getOrDefault(element, 0);
    }

    @Override
    public void removeOccurrence(T element) {
        // TODO Completar con la implementación correspondiente
    	this.elements.computeIfPresent(element, (k, v) -> (v > 1) ? v - 1 : null);
    }

    @Override
    public void removeAll(T element) {
    	this.elements.remove(element);
        // TODO Completar con la implementación correspondiente
    }

    @Override
    public int size() {
        // TODO Completar con la implementación correspondiente
       return elements.values().stream().mapToInt(Integer::intValue).sum();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Iterator<Map.Entry<T, Integer>> entryIterator = elements.entrySet().iterator();
            private Map.Entry<T, Integer> currentEntry;
            private int remainingCount;

            @Override
            public boolean hasNext() {
                return remainingCount > 0 || entryIterator.hasNext();
            }

            @Override
            public T next() {
                if (remainingCount == 0) {
                    currentEntry = entryIterator.next();
                    remainingCount = currentEntry.getValue();
                }
                remainingCount--;
                return currentEntry.getKey();
            }

            @Override
            public void remove() {
                removeOccurrence(currentEntry.getKey());
            }
        };
    }
}
