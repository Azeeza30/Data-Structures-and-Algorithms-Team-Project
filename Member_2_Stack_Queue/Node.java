/**
 * Generic singly-linked node used by LinkedStack and LinkedQueue.
 * Member 2 Work: Stack + Queue
 */
public class Node<T> {
    public T data;
    public Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}
