import java.util.Scanner;

/**
 * Standalone demo/runner for Member 2's Module:
 * Stack (Recent Actions / History) + Queue (Student Service Requests)
 */
public class Member2_Demo {
    private static final LinkedStack<ActionRecord> actionStack = new LinkedStack<>();
    private static final LinkedQueue<ServiceRequest> serviceQueue = new LinkedQueue<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Pre-load sample test data
        actionStack.push(new ActionRecord("ADD", "ST001", "Added Alice Johnson"));
        actionStack.push(new ActionRecord("UPDATE", "ST002", "Updated marks to 85.0"));
        serviceQueue.enqueue(new ServiceRequest("ST001", "Transcript Request"));
        serviceQueue.enqueue(new ServiceRequest("ST002", "ID Card Replacement"));

        while (true) {
            System.out.println("\n=== MEMBER 2 WORK: STACK & QUEUE ===");
            System.out.println("1. Add Service Request to Queue (Enqueue)");
            System.out.println("2. Process Next Service Request (Dequeue)");
            System.out.println("3. Display All Pending Service Requests (Queue)");
            System.out.println("4. Record a New Action (Push to Stack)");
            System.out.println("5. Undo / View Most Recent Action (Pop from Stack)");
            System.out.println("6. Display Recent Actions History (Stack)");
            System.out.println("7. Exit");
            System.out.print("Select an option (1-7): ");

            String input = scanner.nextLine().trim();
            switch (input) {
                case "1":
                    addServiceRequest();
                    break;
                case "2":
                    processServiceRequest();
                    break;
                case "3":
                    serviceQueue.displayAll();
                    break;
                case "4":
                    recordAction();
                    break;
                case "5":
                    popAction();
                    break;
                case "6":
                    actionStack.displayAll();
                    break;
                case "7":
                    System.out.println("Exiting Member 2 Demo. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addServiceRequest() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine().trim();
        System.out.print("Enter Request Description: ");
        String desc = scanner.nextLine().trim();
        if (id.isEmpty() || desc.isEmpty()) {
            System.out.println("Error: Student ID and description cannot be empty.");
            return;
        }
        serviceQueue.enqueue(new ServiceRequest(id, desc));
        actionStack.push(new ActionRecord("ENQUEUE", id, "Added request: " + desc));
        System.out.println("Service request added to queue.");
    }

    private static void processServiceRequest() {
        if (serviceQueue.isEmpty()) {
            System.out.println("Queue is empty. No pending service requests to process.");
            return;
        }
        ServiceRequest req = serviceQueue.dequeue();
        actionStack.push(new ActionRecord("DEQUEUE", req.getStudentId(), "Processed request: " + req.getRequestDescription()));
        System.out.println("Processed: " + req);
    }

    private static void recordAction() {
        System.out.print("Enter Action Type (e.g. ADD/UPDATE/DELETE): ");
        String type = scanner.nextLine().trim();
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine().trim();
        System.out.print("Enter Action Details: ");
        String details = scanner.nextLine().trim();
        actionStack.push(new ActionRecord(type, id, details));
        System.out.println("Action pushed to stack.");
    }

    private static void popAction() {
        if (actionStack.isEmpty()) {
            System.out.println("Stack is empty. No actions to pop.");
            return;
        }
        ActionRecord popped = actionStack.pop();
        System.out.println("Popped most recent action: " + popped);
    }
}
