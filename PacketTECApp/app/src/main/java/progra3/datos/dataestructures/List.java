package progra3.datos.dataestructures;

public class List<T> {

    private Node<T> head;

    private int size;

    public List(){
        this.head = null;
        this.size = 0;
    }

    /**
     * Revisa si la lista esta vacia.
     * @return si la lista esta vacia.
     */
    public boolean is_empty(){
        return this.head == null;
    }

    /**
     * Añade un nodo al inicio.
     * @param data dato del nodo.
     */
    public void add_first(T data){

        Node<T> newNode = new Node<>(data);

        if(is_empty()){
            set_head(newNode);
        }else{
            newNode.setNext(peek());
            set_head(newNode);
        }
        size++;
    }

    /**
     * Añade un nuevo nodo al final de la lista..
     * @param data datos del nodo.
     */
    public void add_last(T data){

        Node<T> newNode = new Node<>(data);

        if(is_empty()){
            set_head(newNode);
        }else{
            Node<T> current = this.head;

            while(current.next() != null){
                current = current.next();
            }
            current.setNext(newNode);
        }
        size++;
    }

    /**
     * remueve la cabeza
     */
    public void remove_head(){
        set_head(peek().next());
        size--;
    }


    /**
     * Limpia la lista.
     */
    public void clear_list(){
       this.head = null;
    }

    /**
     * imprime la lista.
     */
    public void print_list() {
        Node<T> current = this.head;
        while (current != null) {
            System.out.print(current.data() + " ");
            current = current.next();
        }
    }
    
    /**
     * Determina si existe el contenido dentro de la lista.
     * @param element el elemento por encontrar.
     * @return si se encuentra en la lista.
     */
    public boolean contains(T element){

        Node<T> current = this.head;

        while (current.next() != null){
            if(current.data() == element){
                return true;
            }else{
                current = current.next();
            }
        }
        return false;
    }
    
    /**
     * @return la cabeza de la lista.
     */
    public Node<T> peek() {
        return head;
    }
    
    /**
     * @return el tama�o de la lista.
     */
    public int size() {
        return size;
    }
    
    /**
     * Asigna un valor a la cabeza de l alista.
     * @param head la nueva cabeza.
     */
    public void set_head(Node<T> head) {
        this.head = head;
    }
    
    /**
     * Obtiene el nodo en la posici�n dada.
     * @param posicion la posici�n.
     * @return el nodo.
     */
    public Node<T> get(int posicion){

        Node<T> current = head;

        int i = 0;

        while (i < posicion){
            current = current.next();
            i++;
        }

        return current;
    }
    
    /**
     * Elimina un nodo de la lista.
     * @param data la informaci�n por eliminar.
     */
    public void remove(T data){
        Node<T> current = head;

        while (current.data() != null){
            if (current.data() == data || current.data().equals(data)){
                current.setNext(current.next().next());
                return;
            }else {
                current = current.next();
            }
        }
    }

}
