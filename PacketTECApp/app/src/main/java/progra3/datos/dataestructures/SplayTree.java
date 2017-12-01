package progra3.datos.dataestructures;

public class SplayTree<S extends Comparable<S>> {

    private SplayNode<S> root;
    private int count = 0;

    public SplayTree()
    {
        root = null;
    }

    /**
     * @return si el �rbol est� vac�o o no.
     */
    public boolean isEmpty()
    {
        return root == null;
    }

    /**
     * Elimina todo el contenido del �rbol.
     */
    public void clear()
    {
        root = null;
    }

    /**
     * Inserta un nuevo elemento en el �rbol.
     * @param data el contenido.
     * @param key el id del nodo.
     */
    public void insert(S data, int key)
    {
        SplayNode<S> node = root;
        SplayNode<S> secondary_node = null;
        while (node != null)
        {
            secondary_node = node;
            if (key < secondary_node.key)
                node = node.right;
            else
                node = node.left;
        }
        node = new SplayNode<>(data,key);
        node.element = data;
        node.parent = secondary_node;
        if (secondary_node == null)
            root = node;
        else if (key < secondary_node.key)
            secondary_node.right = node;
        else
            secondary_node.left = node;
        splay(node);
        count++;
    }

    /**
     * Rotaci�n izq-izq
     * @param c el nodo hijo.
     * @param p el nodo padre.
     */
    public void makeLeftChildParent(SplayNode<S> c, SplayNode<S> p)
    {
        if ((c == null) || (p == null) || (p.left != c) || (c.parent != p))
            throw new RuntimeException("WRONG");

        if (p.parent != null)
        {
            if (p == p.parent.left)
                p.parent.left = c;
            else
                p.parent.right = c;
        }
        if (c.right != null)
            c.right.parent = p;

        c.parent = p.parent;
        p.parent = c;
        p.left = c.right;
        c.right = p;
    }

    /**
     * Rotaci�n der-der
     * @param c el nodo hijo.
     * @param p el nodo padre.
     */
    public void makeRightChildParent(SplayNode<S> c, SplayNode<S> p)
    {
        if ((c == null) || (p == null) || (p.right != c) || (c.parent != p))
            throw new RuntimeException("WRONG");
        if (p.parent != null)
        {
            if (p == p.parent.left)
                p.parent.left = c;
            else
                p.parent.right = c;
        }
        if (c.left != null)
            c.left.parent = p;
        c.parent = p.parent;
        p.parent = c;
        p.right = c.left;
        c.left = p;
    }

    /**
     * Funci�n que se encarga de balancear el �rbol.
     * @param x el nodo que se quiere balancear.
     */
    private void splay(SplayNode<S> x)
    {
        while (x.parent != null)
        {
            SplayNode<S> Parent = x.parent;
            SplayNode<S> GrandParent = Parent.parent;
            if (GrandParent == null)
            {
                if (x == Parent.left)
                    makeLeftChildParent(x, Parent);
                else
                    makeRightChildParent(x, Parent);
            }
            else
            {
                if (x == Parent.left)
                {
                    if (Parent == GrandParent.left)
                    {
                        makeLeftChildParent(Parent, GrandParent);
                        makeLeftChildParent(x, Parent);
                    }
                    else
                    {
                        makeLeftChildParent(x, x.parent);
                        makeRightChildParent(x, x.parent);
                    }
                }
                else
                {
                    if (Parent == GrandParent.left)
                    {
                        makeRightChildParent(x, x.parent);
                        makeLeftChildParent(x, x.parent);
                    }
                    else
                    {
                        makeRightChildParent(Parent, GrandParent);
                        makeRightChildParent(x, Parent);
                    }
                }
            }
        }
        root = x;
    }

    /**
     * Elimina un nodo del �rbol
     * @param key el id del nodo.
     */
    public void remove(int key)
    {
        SplayNode<S> node = find(key);
        remove(node);
    }

    /**
     * M�todo auxiliar para eliminar un nodo.
     * @param node el nodo inicial.
     */
    private void remove(SplayNode<S> node)
    {
        if (node == null)
            return;

        splay(node);
        if( (node.left != null) && (node.right !=null))
        {
            SplayNode<S> min = node.left;
            while(min.right!=null)
                min = min.right;

            min.right = node.right;
            node.right.parent = min;
            node.left.parent = null;
            root = node.left;
        }
        else if (node.right != null)
        {
            node.right.parent = null;
            root = node.right;
        }
        else if( node.left !=null)
        {
            node.left.parent = null;
            root = node.left;
        }
        else
        {
            root = null;
        }
        node.parent = null;
        node.left = null;
        node.right = null;
        node = null;
        count--;
    }

    /**
     * @return el n�mero de nodos del �rbol.
     */
    public int countNodes()
    {
        return count;
    }

    /**
     * Busca un elemento en el �rbol.
     * @param key el id del nodo.
     * @return si el contenido est� en el �rbol.
     */
    public boolean search(int key)
    {
        return find(key) != null;
    }
    
    /**
     * M�todo auxiliar para encontrar un nodo en el �rbol.
     * @param key el id del nodo.
     * @return el nodo con el contenido si es que existe.
     */
    private SplayNode<S> find(int key){
        SplayNode<S> z = root;
        while (z != null)
        {
            if (key < z.key)
                z = z.right;
            else if (key > z.key)
                z = z.left;
            else
                return z;
        }
        return null;
    }

    /**
     * Recorre el �rbol en orden.
     */
    public void inorder()
    {
        inorder(root);
    }
    /**
     * M�todo auxiliar para recorrer el �rbol en orden.
     * @param r el nodo inicial.
     */
    private void inorder(SplayNode<S> r)
    {
        if (r != null)
        {
            inorder(r.left);
            System.out.print(r.element +" ");
            inorder(r.right);
        }
    }

    /**
     * Recorre el �rbol en pre orden.
     */
    public void preorder()
    {
        preorder(root);
    }
    
    /**
     * M�todo auxiliar para recorrer en pre orden.
     * @param r el nodo inicial.
     */
    private void preorder(SplayNode<S> r)
    {
        if (r != null)
        {
            System.out.print(r.element +" ");
            preorder(r.left);
            preorder(r.right);
        }
    }

    /**
     * Recorre el �rbol en post orden.
     */
    public void postorder()
    {
        postorder(root);
    }
    
    /**
     * M�todo auxiliar para recorrer el �rbol en post orden.
     * @param r el nodo inicial.
     */
    private void postorder(SplayNode<S> r)
    {
        if (r != null)
        {
            postorder(r.left);
            postorder(r.right);
            System.out.print(r.element +" ");
        }
    }
    
    /**
     * @return la ra�z del �rbol.
     */
    public SplayNode<S> root(){
    	return root;
    }
    
    
}
