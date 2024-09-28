/* ==============================================================================
 * @author: Yash Shah
 * @date: 09/21/24
 * 
============================================================================== */

public class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}
