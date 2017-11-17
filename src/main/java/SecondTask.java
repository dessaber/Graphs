import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SecondTask {

    public static class Graph {

        boolean adjacencyMatrix[][];
        int distanceTo[];
        boolean connected[];
        PriorityQueue<Integer> q = new PriorityQueue<>();

        public Graph(int size) {
            adjacencyMatrix = new boolean[size][size];
            distanceTo = new int[size];
            connected = new boolean[size];
            for(int i = 0; i < size ; i++){
                distanceTo[i] = -1;
            }
        }

        public void addEdge(int first, int second) {
            adjacencyMatrix[first][second] = true;
            adjacencyMatrix[second][first] = true;
        }

        public int[] shortestReach(int startId) {
            q.add(startId);
            connected[startId] = true;
            distanceTo[startId] = 0;


            while(!q.isEmpty()){
                int v = q.poll();
                for(int w : adjacents(v)){
                    if(!connected[w]){
                        connected[w] = true;
                        q.add(w);
                        if(distanceTo[w] > distanceTo[v] + 6 || distanceTo[w] == -1) {
                            distanceTo[w] = distanceTo[v] + 6;
                        }
                    }
                }
            }

            return distanceTo;
        }

        public List<Integer> adjacents(int v){
            List<Integer> result = new ArrayList<>();
            for(int i = 0 ; i < adjacencyMatrix[v].length ; i++){
                if (adjacencyMatrix[v][i]) {
                    result.add(i);
                }
            }
            return result;
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
