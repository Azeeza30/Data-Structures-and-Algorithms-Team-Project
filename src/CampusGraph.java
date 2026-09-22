import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Undirected graph modelling the campus network.
 * Vertices = campus locations, edges = roads/paths/connections.
 * Implemented with an adjacency list (Requirement 8).
 * Requirements 7, 9, 10, 11 are covered here (add/remove locations & connections,
 * display network, BFS/DFS traversal).
 */
public class CampusGraph {
    private final Map<String, List<String>> adjList;

    public CampusGraph() {
        adjList = new LinkedHashMap<>();
    }

    public boolean addLocation(String location) {
        if (adjList.containsKey(location)) return false;
        adjList.put(location, new ArrayList<>());
        return true;
    }

    public boolean removeLocation(String location) {
        if (!adjList.containsKey(location)) return false;
        adjList.remove(location);
        for (List<String> neighbours : adjList.values()) {
            neighbours.remove(location);
        }
        return true;
    }

    public boolean locationExists(String location) {
        return adjList.containsKey(location);
    }

    public boolean addConnection(String loc1, String loc2) {
        if (!adjList.containsKey(loc1) || !adjList.containsKey(loc2)) return false;
        if (adjList.get(loc1).contains(loc2)) return false; // avoid duplicate edges
        adjList.get(loc1).add(loc2);
        adjList.get(loc2).add(loc1);
        return true;
    }

    public boolean removeConnection(String loc1, String loc2) {
        if (!adjList.containsKey(loc1) || !adjList.containsKey(loc2)) return false;
        boolean removed1 = adjList.get(loc1).remove(loc2);
        adjList.get(loc2).remove(loc1);
        return removed1;
    }

    public void displayConnections() {
        if (adjList.isEmpty()) {
            System.out.println("No campus locations have been added yet.");
            return;
        }
        System.out.println("---- Campus Network (Adjacency List) ----");
        for (Map.Entry<String, List<String>> entry : adjList.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public void bfs(String start) {
        if (!adjList.containsKey(start)) {
            System.out.println("Error: Location not found: " + start);
            return;
        }
        Set<String> visited = new LinkedHashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        StringBuilder sb = new StringBuilder("BFS Traversal from " + start + ": ");
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            sb.append(cur).append(" ");
            for (String neighbour : adjList.get(cur)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
        System.out.println(sb.toString().trim());
    }

    public void dfs(String start) {
        if (!adjList.containsKey(start)) {
            System.out.println("Error: Location not found: " + start);
            return;
        }
        Set<String> visited = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder("DFS Traversal from " + start + ": ");
        dfsRec(start, visited, sb);
        System.out.println(sb.toString().trim());
    }

    private void dfsRec(String cur, Set<String> visited, StringBuilder sb) {
        visited.add(cur);
        sb.append(cur).append(" ");
        for (String neighbour : adjList.get(cur)) {
            if (!visited.contains(neighbour)) {
                dfsRec(neighbour, visited, sb);
            }
        }
    }
}
