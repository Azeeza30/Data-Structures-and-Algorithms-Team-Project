/**
 * Generic singly-linked node used in Linked List implementation.
 * Member 1 Work: Student Records + Linked List
 */
public class Node<T> {
    public T data;
    public Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}
