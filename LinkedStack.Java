/* ==============================================================================
 * @author: Daniella Jerez
 * @date: 09/25/24
 * 
============================================================================== */

public class LinkedStack <T> {
    
    //pointer 
    private Node <T> front ;

    public LinkedStack (){
        front = null;

    }
    
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
    if (front == null) 
            System.err.println("Stack is empty");

    else {
        T item = front.item;
        front = front.next;
        return item;
        }
    }
}
