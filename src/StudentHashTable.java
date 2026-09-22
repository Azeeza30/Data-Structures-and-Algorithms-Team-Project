import java.util.LinkedList;

/**
 * Custom hash table (separate chaining) supporting O(1) average-case
 * lookup of a student record by Student ID.
 * Requirement 6: use hashing to support efficient student ID searching.
 */
public class StudentHashTable {
    private static final int TABLE_SIZE = 101; // prime table size reduces clustering

    @SuppressWarnings("unchecked")
    private final LinkedList<Student>[] table = new LinkedList[TABLE_SIZE];

    public StudentHashTable() {
        for (int i = 0; i < TABLE_SIZE; i++) table[i] = new LinkedList<>();
    }

    /** Simple polynomial hash function over the characters of the Student ID. */
    private int hash(String studentId) {
        int hashValue = 0;
        for (char c : studentId.toUpperCase().toCharArray()) {
            hashValue = (hashValue * 31 + c) % TABLE_SIZE;
        }
        return Math.floorMod(hashValue, TABLE_SIZE);
    }

    public void insert(Student s) {
        int idx = hash(s.getStudentId());
        table[idx].add(s);
    }

    public Student search(String studentId) {
        int idx = hash(studentId);
        for (Student s : table[idx]) {
            if (s.getStudentId().equalsIgnoreCase(studentId)) return s;
        }
        return null;
    }

    public boolean remove(String studentId) {
        int idx = hash(studentId);
        return table[idx].removeIf(s -> s.getStudentId().equalsIgnoreCase(studentId));
    }
}
