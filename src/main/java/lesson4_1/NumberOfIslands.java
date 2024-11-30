package lesson4_1;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 * https://leetcode.com/problems/number-of-islands/description/
 */
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
