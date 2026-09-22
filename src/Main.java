import java.util.Scanner;

/**
 * CIT300 - Graded Practical Assignment 1
 * University Student Record and Campus Route Management System
 *
 * Menu-driven console application that ties together:
 *  - LinkedListManager (linked list of student records)
 *  - LinkedStack<ActionRecord>  (recent actions / history)
 *  - LinkedQueue<ServiceRequest> (service requests)
 *  - StudentBST (records ordered/searchable by Student ID)
 *  - StudentHashTable (fast Student ID lookup)
 *  - CampusGraph (campus locations + connections, BFS/DFS)
 *
 * NOTE: Each Student object is created once and shared by reference across
 * the linked list, BST and hash table, so an update made via one structure
 * is automatically visible through the others.
 */
public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static final LinkedListManager listManager = new LinkedListManager();
    private static final StudentBST bst = new StudentBST();
    private static final StudentHashTable hashTable = new StudentHashTable();
    private static final LinkedStack<ActionRecord> actionStack = new LinkedStack<>();
    private static final LinkedQueue<ServiceRequest> serviceQueue = new LinkedQueue<>();
    private static final CampusGraph campusGraph = new CampusGraph();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1: addStudentRecord(); break;
                case 2: updateStudentRecord(); break;
                case 3: deleteStudentRecord(); break;
                case 4: listManager.displayAll(); break;
                case 5: addServiceRequest(); break;
                case 6: processNextServiceRequest(); break;
                case 7: actionStack.displayAll(); break;
                case 8: bst.displayInOrder(); break;
                case 9: searchStudentUsingHashing(); break;
                case 10: addCampusLocation(); break;
                case 11: removeCampusLocation(); break;
                case 12: addCampusConnection(); break;
                case 13: removeCampusConnection(); break;
                case 14: campusGraph.displayConnections(); break;
                case 15: traverseCampus(); break;
                case 16: running = false; System.out.println("Exiting system. Goodbye!"); break;
                default: System.out.println("Invalid choice. Please select a valid menu option (1-16).");
            }
        }
        sc.close();
    }

    private static void printMenu() {
        System.out.println("\n===== University Student Record and Campus Route Management System =====");
        System.out.println(" 1. Add Student Record");
        System.out.println(" 2. Update Student Record");
        System.out.println(" 3. Delete Student Record");
        System.out.println(" 4. Display All Records using Linked List");
        System.out.println(" 5. Add Service Request to Queue");
        System.out.println(" 6. Process Next Service Request");
        System.out.println(" 7. Display Recent Actions using Stack");
        System.out.println(" 8. Display Students using BST");
        System.out.println(" 9. Search Student using Hashing");
        System.out.println("10. Add Campus Location");
        System.out.println("11. Remove Campus Location");
        System.out.println("12. Add Campus Connection/Road");
        System.out.println("13. Remove Campus Connection/Road");
        System.out.println("14. Display Campus Connections");
        System.out.println("15. Traverse Campus Locations using BFS or DFS");
        System.out.println("16. Exit");
    }

    // ---------------------------------------------------------------
    // Student record operations (Requirement 12)
    // ---------------------------------------------------------------

    private static void addStudentRecord() {
        String id = readNonEmptyString("Enter Student ID: ");
        if (listManager.isDuplicate(id)) {
            System.out.println("Error: A student with ID " + id + " already exists.");
            return;
        }
        String name = readNonEmptyString("Enter Student Name: ");
        String programme = readNonEmptyString("Enter Programme: ");
        double marks = readValidMarks("Enter Marks (0-100): ");

        Student s = new Student(id, name, programme, marks);
        listManager.addStudent(s);
        bst.insert(s);
        hashTable.insert(s);
        actionStack.push(new ActionRecord("ADD", id, "New record added"));
        System.out.println("Student record added successfully.");
    }

    private static void updateStudentRecord() {
        String id = readNonEmptyString("Enter Student ID to update: ");
        Student s = hashTable.search(id); // demonstrates use of hashing for lookup
        if (s == null) {
            System.out.println("Error: Student ID " + id + " not found.");
            return;
        }

        System.out.println("Leave a field blank to keep its current value.");
        System.out.print("Enter new Name [" + s.getName() + "]: ");
        String name = sc.nextLine().trim();
        System.out.print("Enter new Programme [" + s.getProgramme() + "]: ");
        String programme = sc.nextLine().trim();
        System.out.print("Enter new Marks [" + s.getMarks() + "]: ");
        String marksInput = sc.nextLine().trim();

        if (!name.isEmpty()) s.setName(name);
        if (!programme.isEmpty()) s.setProgramme(programme);
        if (!marksInput.isEmpty()) {
            try {
                double marks = Double.parseDouble(marksInput);
                if (marks >= 0 && marks <= 100) s.setMarks(marks);
                else System.out.println("Invalid marks value ignored (must be between 0 and 100).");
            } catch (NumberFormatException e) {
                System.out.println("Invalid marks input ignored.");
            }
        }
        actionStack.push(new ActionRecord("UPDATE", id, "Record updated"));
        System.out.println("Student record updated successfully.");
    }

    private static void deleteStudentRecord() {
        String id = readNonEmptyString("Enter Student ID to delete: ");
        Student removed = listManager.deleteStudent(id);
        if (removed == null) {
            System.out.println("Error: Student ID " + id + " not found.");
            return;
        }
        bst.delete(id);
        hashTable.remove(id);
        actionStack.push(new ActionRecord("DELETE", id, "Record deleted: " + removed));
        System.out.println("Student record deleted successfully.");
    }

    private static void searchStudentUsingHashing() {
        String id = readNonEmptyString("Enter Student ID to search: ");
        Student s = hashTable.search(id);
        if (s == null) System.out.println("No student found with ID: " + id);
        else System.out.println("Found -> " + s);
    }

    // ---------------------------------------------------------------
    // Queue operations (Requirement 4)
    // ---------------------------------------------------------------

    private static void addServiceRequest() {
        String id = readNonEmptyString("Enter Student ID: ");
        String desc = readNonEmptyString("Enter Service Request Description: ");
        serviceQueue.enqueue(new ServiceRequest(id, desc));
        System.out.println("Service request added to queue.");
    }

    private static void processNextServiceRequest() {
        ServiceRequest req = serviceQueue.dequeue();
        if (req == null) {
            System.out.println("No pending service requests.");
            return;
        }
        System.out.println("Processing request -> " + req);
        actionStack.push(new ActionRecord("SERVICE_PROCESSED", req.getStudentId(), req.getRequestDescription()));
    }

    // ---------------------------------------------------------------
    // Campus graph operations (Requirements 7-11)
    // ---------------------------------------------------------------

    private static void addCampusLocation() {
        String loc = readNonEmptyString("Enter Campus Location name: ");
        if (campusGraph.addLocation(loc)) System.out.println("Location added: " + loc);
        else System.out.println("Error: Location already exists.");
    }

    private static void removeCampusLocation() {
        String loc = readNonEmptyString("Enter Campus Location name to remove: ");
        if (campusGraph.removeLocation(loc)) System.out.println("Location removed: " + loc);
        else System.out.println("Error: Location not found.");
    }

    private static void addCampusConnection() {
        String loc1 = readNonEmptyString("Enter first location: ");
        String loc2 = readNonEmptyString("Enter second location: ");
        if (!campusGraph.locationExists(loc1) || !campusGraph.locationExists(loc2)) {
            System.out.println("Error: Both locations must exist before they can be connected.");
            return;
        }
        if (campusGraph.addConnection(loc1, loc2)) System.out.println("Connection added between " + loc1 + " and " + loc2);
        else System.out.println("Error: That connection already exists.");
    }

    private static void removeCampusConnection() {
        String loc1 = readNonEmptyString("Enter first location: ");
        String loc2 = readNonEmptyString("Enter second location: ");
        if (campusGraph.removeConnection(loc1, loc2)) System.out.println("Connection removed between " + loc1 + " and " + loc2);
        else System.out.println("Error: Connection or location not found.");
    }

    private static void traverseCampus() {
        String start = readNonEmptyString("Enter starting location: ");
        System.out.println("Choose traversal type: 1) BFS   2) DFS");
        int choice = readInt("Enter choice: ");
        if (choice == 1) campusGraph.bfs(start);
        else if (choice == 2) campusGraph.dfs(start);
        else System.out.println("Invalid choice. Please select 1 or 2.");
    }

    // ---------------------------------------------------------------
    // Input validation helpers (Requirements 13, 14)
    // ---------------------------------------------------------------

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }

    private static double readValidMarks(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            try {
                double val = Double.parseDouble(input);
                if (val < 0 || val > 100) {
                    System.out.println("Marks must be between 0 and 100.");
                    continue;
                }
                return val;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
            }
        }
    }

    private static String readNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            if (!input.isEmpty()) return input;
            System.out.println("Input cannot be empty. Please try again.");
        }
    }
}
