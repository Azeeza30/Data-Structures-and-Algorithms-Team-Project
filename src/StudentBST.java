/**
 * Binary Search Tree that organises student records by Student ID.
 * Requirement 5: use a BST or AVL tree to organise/search student records.
 */
public class StudentBST {

    private class TreeNode {
        Student data;
        TreeNode left, right;
        TreeNode(Student data) { this.data = data; }
    }

    private TreeNode root;

    public void insert(Student s) {
        root = insertRec(root, s);
    }

    private TreeNode insertRec(TreeNode node, Student s) {
        if (node == null) return new TreeNode(s);
        int cmp = s.getStudentId().compareToIgnoreCase(node.data.getStudentId());
        if (cmp < 0) node.left = insertRec(node.left, s);
        else if (cmp > 0) node.right = insertRec(node.right, s);
        // if cmp == 0 the id already exists; keep the original node (duplicates are
        // prevented earlier by LinkedListManager.isDuplicate before insert is ever called)
        return node;
    }

    public Student search(String studentId) {
        TreeNode cur = root;
        while (cur != null) {
            int cmp = studentId.compareToIgnoreCase(cur.data.getStudentId());
            if (cmp == 0) return cur.data;
            cur = (cmp < 0) ? cur.left : cur.right;
        }
        return null;
    }

    public void delete(String studentId) {
        root = deleteRec(root, studentId);
    }

    private TreeNode deleteRec(TreeNode node, String studentId) {
        if (node == null) return null;
        int cmp = studentId.compareToIgnoreCase(node.data.getStudentId());
        if (cmp < 0) {
            node.left = deleteRec(node.left, studentId);
        } else if (cmp > 0) {
            node.right = deleteRec(node.right, studentId);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            // two children: replace with in-order successor (smallest in right subtree)
            TreeNode successor = node.right;
            while (successor.left != null) successor = successor.left;
            node.data = successor.data;
            node.right = deleteRec(node.right, successor.data.getStudentId());
        }
        return node;
    }

    public void displayInOrder() {
        System.out.println("---- Student Records (BST, sorted by Student ID) ----");
        if (root == null) {
            System.out.println("No records.");
            return;
        }
        inOrderRec(root);
    }

    private void inOrderRec(TreeNode node) {
        if (node == null) return;
        inOrderRec(node.left);
        System.out.println(node.data);
        inOrderRec(node.right);
    }
}
