import java.util.Scanner;

/**
 * Standalone demo/runner for Member 4's Module:
 * Campus Graph (Locations, Roads/Connections, Adjacency List, BFS, DFS)
 */
public class Member4_Demo {
    private static final CampusGraph graph = new CampusGraph();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Pre-load sample campus network
        graph.addLocation("Main Gate");
        graph.addLocation("Library");
        graph.addLocation("IT Block");
        graph.addLocation("Cafeteria");
        graph.addLocation("Sports Complex");

        graph.addConnection("Main Gate", "Library");
        graph.addConnection("Main Gate", "Cafeteria");
        graph.addConnection("Library", "IT Block");
        graph.addConnection("Cafeteria", "IT Block");
        graph.addConnection("Cafeteria", "Sports Complex");

        while (true) {
            System.out.println("\n=== MEMBER 4 WORK: CAMPUS GRAPH & TRAVERSALS ===");
            System.out.println("1. Add Campus Location");
            System.out.println("2. Remove Campus Location");
            System.out.println("3. Add Campus Connection / Road");
            System.out.println("4. Remove Campus Connection / Road");
            System.out.println("5. Display Campus Network (Adjacency List)");
            System.out.println("6. Traverse Campus using BFS (Breadth-First Search)");
            System.out.println("7. Traverse Campus using DFS (Depth-First Search)");
            System.out.println("8. Exit");
            System.out.print("Select an option (1-8): ");

            String input = scanner.nextLine().trim();
            switch (input) {
                case "1":
                    addLocation();
                    break;
                case "2":
                    removeLocation();
                    break;
                case "3":
                    addConnection();
                    break;
                case "4":
                    removeConnection();
                    break;
                case "5":
                    graph.displayConnections();
                    break;
                case "6":
                    traverseBFS();
                    break;
                case "7":
                    traverseDFS();
                    break;
                case "8":
                    System.out.println("Exiting Member 4 Demo. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addLocation() {
        System.out.print("Enter Location Name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Error: Location name cannot be empty.");
            return;
        }
        if (graph.addLocation(name)) {
            System.out.println("Location '" + name + "' added successfully.");
        } else {
            System.out.println("Error: Location already exists.");
        }
    }

    private static void removeLocation() {
        System.out.print("Enter Location Name to remove: ");
        String name = scanner.nextLine().trim();
        if (graph.removeLocation(name)) {
            System.out.println("Location '" + name + "' and its connecting roads removed successfully.");
        } else {
            System.out.println("Error: Location not found.");
        }
    }

    private static void addConnection() {
        System.out.print("Enter First Location: ");
        String loc1 = scanner.nextLine().trim();
        System.out.print("Enter Second Location: ");
        String loc2 = scanner.nextLine().trim();
        if (loc1.equalsIgnoreCase(loc2)) {
            System.out.println("Error: Cannot connect a location to itself.");
            return;
        }
        if (graph.addConnection(loc1, loc2)) {
            System.out.println("Connection between '" + loc1 + "' and '" + loc2 + "' added successfully.");
        } else {
            System.out.println("Error: One or both locations do not exist, or connection already exists.");
        }
    }

    private static void removeConnection() {
        System.out.print("Enter First Location: ");
        String loc1 = scanner.nextLine().trim();
        System.out.print("Enter Second Location: ");
        String loc2 = scanner.nextLine().trim();
        if (graph.removeConnection(loc1, loc2)) {
            System.out.println("Connection between '" + loc1 + "' and '" + loc2 + "' removed successfully.");
        } else {
            System.out.println("Error: Connection does not exist or invalid locations.");
        }
    }

    private static void traverseBFS() {
        System.out.print("Enter Start Location for BFS: ");
        String start = scanner.nextLine().trim();
        graph.bfs(start);
    }

    private static void traverseDFS() {
        System.out.print("Enter Start Location for DFS: ");
        String start = scanner.nextLine().trim();
        graph.dfs(start);
    }
}
