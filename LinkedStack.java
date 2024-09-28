/* ==============================================================================
 * @author: Daniella Jerez
 * @date: 09/25/24
 * 
============================================================================== */

public class LinkedStack<T> {

    // Pointer to the top of the stack
    private Node<T> front;
    private int size;  // To track the size of the stack

    // Constructor for the LinkedStack
    public LinkedStack() {
        this.front = null;
        this.size = 0;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Push an item onto the stack
    public void push(T item) {
        Node<T> oldFront = front;
        front = new Node<>(item, oldFront);  // Use the constructor of Node to initialize the item and the next node
        size++;
    }

    // Pop an item from the stack
    public T pop() {
        if (front == null) {
            System.err.println("Stack is empty");
            return null;
        } else {
            T item = front.item;
            front = front.next;
            size--;
            return item;
        }
    }

    // Get the size of the stack
    public int size() {
        return size;
    }

    // Node class definition
    private static class Node<T> {
        T item;
        Node<T> next;

        // Constructor to initialize Node with an item and a reference to the next Node
        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }
}
