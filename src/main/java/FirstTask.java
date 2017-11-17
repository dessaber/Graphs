import java.util.Scanner;

public class FirstTask {

    public static class Graph{
        boolean visited[][];
        int grid[][];
        int n;
        int m;
        int maxCount;
        int counter;

        Graph(int n , int m){
            grid = new int[n][m];
            visited = new boolean[n][m];
        }

        public int getMax(){
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < m ; j++) {
                    counter = 0;
                    dfs(i, j);
                    if (counter > maxCount) maxCount = counter;
                }
            }

            return maxCount;
        }

         private void dfs(int x, int y) {
            if (x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == 1 && !visited[x][y]) {
                visited[x][y] = true;
                counter++;

                for (int i = x - 1; i <= x + 1; i++) {
                    for (int j = y - 1; j <= y + 1; j++) {
                        dfs(i, j);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Graph graph = new Graph(n, m);

        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                graph.grid[grid_i][grid_j] = in.nextInt();
            }
        }

        System.out.println(graph.getMax());
    }

}
