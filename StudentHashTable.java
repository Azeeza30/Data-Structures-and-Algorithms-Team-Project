package Students;


import java.util.HashMap;

public class StudentHashTable {

    private HashMap<Integer, Student> table;

    public StudentHashTable() {

        table = new HashMap<>();
    }

    // Add student
    public void put(Student student) {

        table.put(student.getStudentId(), student);
    }

    // Search student
    public Student search(int studentId) {

        return table.get(studentId);
    }

    // Delete student
    public void remove(int studentId) {

        table.remove(studentId);
    }
}
