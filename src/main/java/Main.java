import java.util.Scanner;

public class Main {
    static boolean visited[][];
    static int grid[][];
    static int n;
    static int m;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        grid = new int[n][m];
        visited = new boolean[n][m];

        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){

                if(grid[i][j] == 1 && !visited[i][j]){
                    dfs(i, j);
                }
            }
        }
    }

    static void dfs(int x, int y){
        if (x >= 0 && y >= 0 && x < n && y < m) {
            visited[x][y] = true;

            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y - 1; j <= y + 1; j++) {
                    if (grid[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                    }
                }
            }
        }


    }

}
