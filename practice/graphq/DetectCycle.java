package practice.graphq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * DetectCycle
 */
public class DetectCycle {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> zeroAdj = new ArrayList<Integer>(Arrays.asList(1, 2));
        ArrayList<Integer> firstAdj = new ArrayList<Integer>(Arrays.asList(4, 3, 0));
        // ArrayList<Integer> secondAdj = new ArrayList<Integer>(Arrays.asList(3, 5,
        // 0));
        ArrayList<Integer> secondAdj = new ArrayList<Integer>(Arrays.asList(5, 0));
        // ArrayList<Integer> thirdAdj = new ArrayList<Integer>(Arrays.asList(1, 2));
        ArrayList<Integer> thirdAdj = new ArrayList<Integer>(Arrays.asList(1));
        ArrayList<Integer> fourthAdj = new ArrayList<Integer>(Arrays.asList(1));
        ArrayList<Integer> fifthAdj = new ArrayList<Integer>(Arrays.asList(2));

        adj.add(zeroAdj);
        adj.add(firstAdj);
        adj.add(secondAdj);
        adj.add(thirdAdj);
        adj.add(fourthAdj);
        adj.add(fifthAdj);

        System.out.println(isCyclic(6, adj));
    }

    static Boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {

        // Mark all the vertices as
        // not visited and not part of
        // recursion stack
        Boolean visited[] = new Boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;

        // Call the recursive helper
        // function to detect cycle in
        // different DFS trees
        for (int u = 0; u < V; u++) {

            // Don't recur for u if already visited
            if (!visited[u])
                if (isCyclicUtil(u, visited, -1, adj))
                    return true;
        }

        return false;

    }

    static Boolean isCyclicUtil(int v, Boolean visited[], int parent, ArrayList<ArrayList<Integer>> adj) {
        // Mark the current node as visited
        visited[v] = true;
        Integer i;

        // Recur for all the vertices
        // adjacent to this vertex
        // Iterator<Integer> it = adj[v].iterator();
        ArrayList<Integer> it = adj.get(v);

        for (Integer integer : it) {
            i = integer;

            // If an adjacent is not
            // visited, then recur for that
            // adjacent
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, v, adj))
                    return true;
            }

            // If an adjacent is visited
            // and not parent of current
            // vertex, then there is a cycle.
            else if (i != parent)
                return true;
        }

        return false;
    }

}
