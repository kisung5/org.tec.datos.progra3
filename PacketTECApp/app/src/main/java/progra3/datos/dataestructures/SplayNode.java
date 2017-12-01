package progra3.datos.dataestructures;


public class SplayNode<S> {

    public SplayNode<S> left;
	public SplayNode<S> right;
	public SplayNode<S> parent;
    public int key;
    public S element;

    
    public SplayNode(S data, int key)
    {
        this(data, key, null, null, null);
    }
  
    public SplayNode(S element,int key, SplayNode<S> left, SplayNode<S> right, SplayNode<S> parent)
    {
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.element = element;
        this.key = key;
    }
}
