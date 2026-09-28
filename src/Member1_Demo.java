import java.util.Scanner;

/**
 * Standalone demo/runner for Member 1's Module:
 * Student Records + Linked List (Add, Update, Delete, Search, Display)
 */
public class Member1_Demo {
    private static final LinkedListManager listManager = new LinkedListManager();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Pre-load sample test data
        listManager.addStudent(new Student("ST001", "Alice Johnson", "Computer Science", 88.5));
        listManager.addStudent(new Student("ST002", "Bob Smith", "Information Systems", 74.0));
        listManager.addStudent(new Student("ST003", "Charlie Brown", "Software Engineering", 91.0));

        while (true) {
            System.out.println("\n=== MEMBER 1 WORK: STUDENT RECORDS & LINKED LIST ===");
            System.out.println("1. Add Student Record");
            System.out.println("2. Update Student Record");
            System.out.println("3. Delete Student Record");
            System.out.println("4. Search Student Record");
            System.out.println("5. Display All Records (Linked List)");
            System.out.println("6. Exit");
            System.out.print("Select an option (1-6): ");

            String input = scanner.nextLine().trim();
            switch (input) {
                case "1":
                    addStudent();
                    break;
                case "2":
                    updateStudent();
                    break;
                case "3":
                    deleteStudent();
                    break;
                case "4":
                    searchStudent();
                    break;
                case "5":
                    listManager.displayAll();
                    break;
                case "6":
                    System.out.println("Exiting Member 1 Demo. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            System.out.println("Error: Student ID cannot be empty.");
            return;
        }
        if (listManager.isDuplicate(id)) {
            System.out.println("Error: Student ID already exists.");
            return;
        }

        System.out.print("Enter Name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter Programme: ");
        String prog = scanner.nextLine().trim();
        System.out.print("Enter Marks (0 - 100): ");
        double marks;
        try {
            marks = Double.parseDouble(scanner.nextLine().trim());
            if (marks < 0 || marks > 100) {
                System.out.println("Error: Marks must be between 0 and 100.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format for marks.");
            return;
        }

        Student s = new Student(id, name, prog, marks);
        listManager.addStudent(s);
        System.out.println("Student added successfully to Linked List.");
    }

    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        String id = scanner.nextLine().trim();
        Student s = listManager.findStudent(id);
        if (s == null) {
            System.out.println("Error: Student record not found.");
            return;
        }

        System.out.println("Current details: " + s);
        System.out.print("Enter new Name (press Enter to keep current): ");
        String name = scanner.nextLine().trim();
        if (!name.isEmpty()) s.setName(name);

        System.out.print("Enter new Programme (press Enter to keep current): ");
        String prog = scanner.nextLine().trim();
        if (!prog.isEmpty()) s.setProgramme(prog);

        System.out.print("Enter new Marks (press Enter to keep current): ");
        String marksStr = scanner.nextLine().trim();
        if (!marksStr.isEmpty()) {
            try {
                double marks = Double.parseDouble(marksStr);
                if (marks >= 0 && marks <= 100) {
                    s.setMarks(marks);
                } else {
                    System.out.println("Warning: Marks out of range (0-100). Keeping old marks.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Warning: Invalid number. Keeping old marks.");
            }
        }
        System.out.println("Student record updated successfully.");
    }

    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        String id = scanner.nextLine().trim();
        Student deleted = listManager.deleteStudent(id);
        if (deleted != null) {
            System.out.println("Deleted record: " + deleted);
        } else {
            System.out.println("Error: Student ID not found.");
        }
    }

    private static void searchStudent() {
        System.out.print("Enter Student ID to search: ");
        String id = scanner.nextLine().trim();
        Student s = listManager.findStudent(id);
        if (s != null) {
            System.out.println("Found record: " + s);
        } else {
            System.out.println("Student not found in Linked List.");
        }
    }
}
