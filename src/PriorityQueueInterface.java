/**
 * Extraido de: "Java Structures: Data Structures for the Principled Programmer, Seccion 14.4"
 * Clase que permite el uso de cualquier objeto o dato primitivo
 */
public interface PriorityQueueInterface<E extends Comparable<E>> {
    
	/**
     * @param value Objeto o dato primitivo
     */
    public void add(E value);

	/**
     * @return Devuelve el primer dato 
     */
    public E getFirst();

    /**
     * @return PrioriQueue
     */
    public E remove();

    /**
     * @return Devuelve un false o true. Verdadero si esta vacio, falso de lo contrario.
     */
    public boolean isEmpty();

    /**
     * @return Un int del tamaño del PriorityQueue
     */
    public int size();

    /**
     * Remueve todos los elementos del PriorityQueue
     */
    public void clear();
}