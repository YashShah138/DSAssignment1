/* ==============================================================================
 * @author: Yash Shah
 * @date: 09/21/24
 * 
============================================================================== */


public class LinkedQueue<T> {
    private Node<T> front;
    private Node<T> end;

    public LinkedQueue() {
        this.front = null;
        this.end = null;
    }

    // Enqueue method
    public void enqueue(T data) {
        Node<T> newNode = new Node<> (data);
        
        if (end == null) {
            front = end = newNode;
        } else {
            end.next = newNode;
            end = newNode;
        }
    }

    // Dequeue method
    public T dequeue() {
        if (front == null) {
            System.err.println("Queue is empty");
        }

        T data = front.data;
        front =front.next;
        
        if (front == null) {
            end = null;
        }

        return data;
    }

    // CheckEmpty method
    public boolean isEmpty() {
        return front == end;
    }
}

