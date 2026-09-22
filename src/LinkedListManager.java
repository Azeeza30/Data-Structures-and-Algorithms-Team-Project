/**
 * Singly linked list used as the primary store for student records.
 * Requirement 2: use a linked list to store and manage student records.
 */
public class LinkedListManager {
    private Node<Student> head;
    private int size;

    public LinkedListManager() {
        head = null;
        size = 0;
    }

    public boolean isDuplicate(String studentId) {
        Node<Student> cur = head;
        while (cur != null) {
            if (cur.data.getStudentId().equalsIgnoreCase(studentId)) return true;
            cur = cur.next;
        }
        return false;
    }

    public void addStudent(Student s) {
        Node<Student> newNode = new Node<>(s);
        if (head == null) {
            head = newNode;
        } else {
            Node<Student> cur = head;
            while (cur.next != null) cur = cur.next;
            cur.next = newNode;
        }
        size++;
    }

    public Student findStudent(String studentId) {
        Node<Student> cur = head;
        while (cur != null) {
            if (cur.data.getStudentId().equalsIgnoreCase(studentId)) return cur.data;
            cur = cur.next;
        }
        return null;
    }

    public Student deleteStudent(String studentId) {
        Node<Student> cur = head, prev = null;
        while (cur != null) {
            if (cur.data.getStudentId().equalsIgnoreCase(studentId)) {
                if (prev == null) head = cur.next;
                else prev.next = cur.next;
                size--;
                return cur.data;
            }
            prev = cur;
            cur = cur.next;
        }
        return null;
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No student records found.");
            return;
        }
        System.out.println("---- All Student Records (Linked List) ----");
        Node<Student> cur = head;
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }

    public int getSize() { return size; }
}
