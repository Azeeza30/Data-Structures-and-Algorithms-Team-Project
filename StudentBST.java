package Students;


public class StudentBST {

    private static class Node {

        Student student;
        Node left;
        Node right;

        Node(Student student) {
            this.student = student;
        }
    }

    private Node root;

    // Insert student
    public boolean insert(Student student) {

        if (root == null) {
            root = new Node(student);
            return true;
        }

        return insertRecursive(root, student);
    }

    private boolean insertRecursive(Node current,
                                    Student student) {

        if (student.getStudentId()
                == current.student.getStudentId()) {

            return false;
        }

        if (student.getStudentId()
                < current.student.getStudentId()) {

            if (current.left == null) {

                current.left = new Node(student);
                return true;
            }

            return insertRecursive(current.left, student);

        } else {

            if (current.right == null) {

                current.right = new Node(student);
                return true;
            }

            return insertRecursive(current.right, student);
        }
    }

    // Search student
    public Student search(int studentId) {

        Node current = root;

        while (current != null) {

            if (studentId == current.student.getStudentId()) {
                return current.student;
            }

            if (studentId < current.student.getStudentId()) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return null;
    }

    // Display students in sorted Student ID order
    public void displayInOrder() {

        if (root == null) {

            System.out.println("BST is empty.");
            return;
        }

        inOrder(root);
    }

    private void inOrder(Node node) {

        if (node == null) {
            return;
        }

        inOrder(node.left);

        System.out.println(node.student);

        inOrder(node.right);
    }
}
