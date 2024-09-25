/* ==============================================================================
 * @author: Daniella Jerez
 * @date: 09/25/24
 * 
============================================================================== */

public class LinkedStack <T> {
    
    //pointer 
    private Node <T> front = null;

    
    //checks if linked list is empty 
    public boolean isEmpty()
    { return first == null; }

    //pushing numbers into linked list 
    public void push(T item)
    {
        Node oldfirst = front;
        front = new Node();
        front.item = item;
        front.next = oldfirst;
    }
    
    //poping numbers of linked list 
    public T pop()
    {
        T item = front.item;
        front = front.next;
        return item;
    }
}
