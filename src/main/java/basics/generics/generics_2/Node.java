package basics.generics.generics_2;

/**
 * Created by rajani.maski on 7/17/17.
 */
public class Node<E> {

    public Node next;
    private E item;

    public Node() {
        this(null, null);
    }

    public Node(E data, Node n) {
        setItem(data);
        setNext(n);
    }

    public E getItem() {
        return item;
    }

    public void setItem(E data) {
        this.item = data;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> node) {
        next = node;
    }

}
