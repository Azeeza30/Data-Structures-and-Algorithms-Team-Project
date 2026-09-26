/**
 * Generic FIFO queue implemented with linked nodes.
 * Member 2 Work: Stack + Queue
 * Responsibility: Manage student service requests in arrival order (FIFO).
 */
public class LinkedQueue<T> {
    private Node<T> front, rear;
    private int size;

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public T dequeue() {
        if (isEmpty()) return null;
        T data = front.data;
        front = front.next;
        if (front == null) rear = null;
        size--;
        return data;
    }

    public boolean isEmpty() { return front == null; }
    public int getSize() { return size; }

    public void displayAll() {
        if (isEmpty()) {
            System.out.println("No pending service requests.");
            return;
        }
        System.out.println("---- Pending Service Requests (Queue, front to rear) ----");
        Node<T> cur = front;
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }
}
