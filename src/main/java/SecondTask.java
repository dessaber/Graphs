import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SecondTask {

    public static class Graph {

        boolean adjacencyMatrix[][];
        int distanceTo[];
        PriorityQueue<Integer> q = new PriorityQueue<>();

        public Graph(int size) {
            adjacencyMatrix = new boolean[size][size];
            distanceTo = new int[size];
            for(int i : distanceTo){
                i=-1;
            }
        }

        public void addEdge(int first, int second) {
            adjacencyMatrix[first-1][second-1] = true;
        }

        public int[] shortestReach(int startId) {
            q.add(startId-1);

            return new int[0];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int queries = scanner.nextInt();

        for (int t = 0; t < queries; t++) {

            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();

            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;

                // add each edge to the graph
                graph.addEdge(u, v);
            }

            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);

            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}
