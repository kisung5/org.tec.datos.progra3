package progra3.datos.dataestructures;

public class Node<T> {

    private T data;
    private Node<T> next;

    public Node(T data){
        this.data = data;
        this.next = null;
    }
    
    /** 
     * @return si se tiene una referencia al siguiente.
     */
    public boolean hasNext(){
        return this.next() == null;
    }
    
    /**
     * @return la informaci�n del nodo.
     */
    public T data() {
        return data;
    }
    
    /**
     * Asigna un valor al contenido del nodo.
     * @param data el contenido.
     */
    public void setData(T data) {
        this.data = data;
    }
    
    /**
     * @return la referencia al nodo siguiente.
     */
    public Node<T> next() {
        return next;
    }
    
    /**
     * Asigna un valor a la referencia siguiente.
     * @param next
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }


}
