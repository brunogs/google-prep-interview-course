package lesson4_1;

public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = {
                {'1','0','1','1','1'},
                {'1','0','1','0','1'},
                {'1','1','1','0','1'}
        };
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int total = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] == '1') {
                    if (visitIsland(grid, i, j, visited)) {
                        total++;
                    }
                }
            }
        }

        return total;
    }

    public static boolean visitIsland(char[][] grid, int i, int j, boolean[][] visited) {
        boolean outOfGrid = i < 0 || i >= grid.length || j < 0 || j >= grid[i].length;
        if (outOfGrid || grid[i][j] == '0' || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        int up = i-1;
        while (visitIsland(grid, up, j, visited)) {
            up--;
        }
        int left = j-1;
        while (visitIsland(grid, i, left, visited)) {
            left--;
        }
        int right = j+1;
        while (visitIsland(grid, i, right, visited)) {
            right++;
        }
        int down = i+1;
        while (visitIsland(grid, down, j, visited)) {
            down++;
        }
        return true;
    }
}
