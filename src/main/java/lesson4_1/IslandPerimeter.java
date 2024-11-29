package lesson4_1;

public class IslandPerimeter {

    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(islandPerimeterProcedural(grid));

        System.out.println(islandPerimeterDfs(grid));
    }

    public static int islandPerimeterProcedural(int[][] grid) {
        int stripes = 4;
        int total = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] == 1) {

                    total += stripes;
                    // up
                    if (i > 0 && grid[i-1][j] == 1) {
                        total--;
                    }
                    // left
                    if (j > 0 && grid[i][j-1] == 1) {
                        total--;
                    }
                    // right
                    if (j < grid[i].length-1 && grid[i][j+1] == 1) {
                        total--;
                    }
                    // down
                    if (i < grid.length-1 && grid[i+1][j] == 1) {
                        total--;
                    }
                }
            }
        }
        return total;
    }

    public static int islandPerimeterDfsAux(int[][] grid, boolean[][] visited, int i, int j) {
        boolean outOfGrid = i < 0 || i >= grid.length || j < 0 || j >= grid[i].length;
        if (outOfGrid || grid[i][j] == 0) {
            return 1;
        }
        if (visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        int subtotal = 0;
        int up = i-1;
        subtotal += islandPerimeterDfsAux(grid, visited, up, j);
        int left = j-1;
        subtotal += islandPerimeterDfsAux(grid, visited, i, left);
        int right = j+1;
        subtotal += islandPerimeterDfsAux(grid, visited, i, right);
        int down = i+1;
        subtotal += islandPerimeterDfsAux(grid, visited, down, j);

        return subtotal;
    }

    public static int islandPerimeterDfs(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int total = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    total += islandPerimeterDfsAux(grid, visited, i, j);
                }
            }
        }
        return total;
    }
}
