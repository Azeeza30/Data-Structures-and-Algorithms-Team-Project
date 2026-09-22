/**
 * Generic stack implemented with linked nodes.
 * Requirement 3: use a stack to maintain recent actions / undo history.
 */
public class LinkedStack<T> {
    private Node<T> top;
    private int size;

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T pop() {
        if (isEmpty()) return null;
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    public T peek() {
        return isEmpty() ? null : top.data;
    }

    public boolean isEmpty() { return top == null; }
    public int getSize() { return size; }

    public void displayAll() {
        if (isEmpty()) {
            System.out.println("No recent actions recorded.");
            return;
        }
        System.out.println("---- Recent Actions (Stack, most recent first) ----");
        Node<T> cur = top;
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }
}
