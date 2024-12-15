package lesson4_1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {

    public static void main(String[] args) {
        int[][] matrix = {{0,0,0},{0,1,0},{1,1,1}};
        int [][] result = updateMatrix(matrix);

        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }

    public static int[][] updateMatrix(int[][] mat) {
        boolean[][] visited = new boolean[mat.length][mat[0].length];

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0 && !visited[i][j]) {
                    queue.add(new int[]{i, j, 1});
                }
            }
        }

        fillNonZeroPosition(mat, queue, visited);

        return mat;
    }

    /*
    [
        [0,0,0],
        [0,1,0],
        [1,1,1]
    ]
    */
    public static void fillNonZeroPosition(int[][] mat, Queue<int[]> queue, boolean[][] visited) {

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        // 1

        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int x = position[0];
            int y = position[1];
            int currentDistance = position[2];

            if (mat[x][y] != 0) {
                mat[x][y] = currentDistance;
            }

            for (int idx = 0; idx < directions.length; idx++) {
                int newX = x + directions[idx][0];
                int newY = y + directions[idx][1];
                boolean validGridPosition = newX >= 0 && newX < mat.length && newY >= 0 && newY < mat[newX].length;
                if (validGridPosition && !visited[newX][newY] && mat[newX][newY] == 1) {
                    visited[newX][newY] = true;
                    int distance = mat[x][y]+1;
                    queue.add(new int[]{newX, newY, distance});
                }
            }
        }
    }
}
