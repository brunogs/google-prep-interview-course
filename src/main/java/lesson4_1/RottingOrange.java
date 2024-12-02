package lesson4_1;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOrange {

    public static void main(String[] args) {
        int[][] grid = {
            {2,1,1},
            {1,1,0},
            {0,1,1}
        };
        int result = orangesRotting(grid);

        System.out.println(result);
    }

    public static int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        // find start points
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int minutes = 0;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            minutes++;

            // run the entire layer
            while (queueSize > 0) {
                int[] positions = queue.poll();
                int i = positions[0];
                int j = positions[1];

                // up
                if (i > 0 && grid[i-1][j] == 1) {
                    grid[i-1][j] = 2;
                    queue.add(new int[]{i-1, j});
                }
                // left
                if (j > 0 && grid[i][j-1] == 1) {
                    grid[i][j-1] = 2;
                    queue.add(new int[]{i, j-1});
                }
                // right
                if (j < grid[i].length-1 && grid[i][j+1] == 1) {
                    grid[i][j+1] = 2;
                    queue.add(new int[]{i, j+1});
                }
                // down
                if (i < grid.length-1 && grid[i+1][j] == 1) {
                    grid[i+1][j] = 2;
                    queue.add(new int[]{i+1, j});
                }

                queueSize--;
            }
        }

        // find start points
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        // I need to return minutes-1, because I start the count in the first node where none minute past yet
        return Math.max(0, minutes-1);
    }
}
