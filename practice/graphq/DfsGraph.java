package practice.graphq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * DfsGraph
 */
public class DfsGraph {

    /**
     * Given a connected undirected graph. Perform a Depth First Traversal of the
     * graph. Note: Use recursive approach to find the BFS traversal of the graph
     * starting from the 0th vertex from left to right according to the graph..
     **/
    public static void main(String[] args) {
        System.out.println("Hello There!!");
        Graph graph = new Graph();

        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(4, 5);

        graph.dfs(0);

        System.out.println("Lets Try ANother!!!");

        Graph someGraph = new Graph();

        someGraph.addVertex(0);
        someGraph.addVertex(1);
        someGraph.addVertex(2);
        someGraph.addVertex(3);
        someGraph.addVertex(4);
        someGraph.addVertex(5);
        someGraph.addVertex(6);
        someGraph.addVertex(7);

        someGraph.addEdge(0, 1);
        someGraph.addEdge(0, 2);
        someGraph.addEdge(0, 3);
        someGraph.addEdge(3, 5);
        someGraph.addEdge(3, 4);
        someGraph.addEdge(5, 6);
        someGraph.addEdge(5, 7);

        someGraph.dfs(0);

        System.out.println("Lets Try ANother!!!");
        System.out.println();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> zeroAdj = new ArrayList<Integer>(Arrays.asList(1, 2));
        ArrayList<Integer> firstAdj = new ArrayList<Integer>(Arrays.asList(3, 4));
        ArrayList<Integer> secondAdj = new ArrayList<Integer>(Arrays.asList());
        ArrayList<Integer> thirdAdj = new ArrayList<Integer>(Arrays.asList());
        ArrayList<Integer> fourthAdj = new ArrayList<Integer>(Arrays.asList(5));
        ArrayList<Integer> fifthAdj = new ArrayList<Integer>(Arrays.asList());

        adj.add(zeroAdj);
        adj.add(firstAdj);
        adj.add(secondAdj);
        adj.add(thirdAdj);
        adj.add(fourthAdj);
        adj.add(fifthAdj);

        ArrayList<Integer> result = dfsOfGraph(0, adj);

        for (Integer integer : result) {
            System.out.print(integer + " ");
        }

        // BFS question
        System.out.println("Lets Try BFS!!!");
        System.out.println();
        ArrayList<ArrayList<Integer>> adjj = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> zeroAdjj = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> firstAdjj = new ArrayList<Integer>(Arrays.asList(0));
        ArrayList<Integer> secondAdjj = new ArrayList<Integer>(Arrays.asList(0, 4));
        ArrayList<Integer> thirdAdjj = new ArrayList<Integer>(Arrays.asList(0));
        ArrayList<Integer> fourthAdjj = new ArrayList<Integer>(Arrays.asList(2));

        adjj.add(zeroAdjj);
        adjj.add(firstAdjj);
        adjj.add(secondAdjj);
        adjj.add(thirdAdjj);
        adjj.add(fourthAdjj);

        ArrayList<Integer> resrlt = bfsOfGraph(0, adjj);

        for (Integer integer : resrlt) {
            System.out.print(integer + " ");
        }
    }

    static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> result = new ArrayList<Integer>();

        boolean[] visited = new boolean[adj.size()];
        ArrayList<Integer> queue = new ArrayList<>();

        bfsRecursive(0, adj, visited, queue, result);

        return result;

    }

    static void bfsRecursive(int current, ArrayList<ArrayList<Integer>> adj, boolean[] visited,
            ArrayList<Integer> queueList, ArrayList<Integer> result) {

        visited[current] = true;
        queueList.add(current);

        while (queueList.size() != 0) {
            current = queueList.remove(0);
            visit(current, result);

            ArrayList<Integer> currentList = adj.get(current);
            for (Integer integer : currentList) {
                if (!visited[integer]) {
                    visited[integer] = true;
                    queueList.add(integer);
                }

            }
        }
    }

    static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        boolean[] isVisited = new boolean[adj.size()];
        dfsRecursive(0, adj, isVisited, result);

        return result;
    }

    static void dfsRecursive(int current, ArrayList<ArrayList<Integer>> adj, boolean[] isVisited,
            ArrayList<Integer> result) {
        isVisited[current] = true;
        visit(current, result);
        for (int dest : adj.get(current)) {
            if (!isVisited[dest])
                dfsRecursive(dest, adj, isVisited, result);
        }
    }

    static void visit(int value, ArrayList<Integer> result) {
        result.add(value);
    }

}
