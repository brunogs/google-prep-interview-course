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

        /*
        [
         0   [0,0,0],
         1   [0,1,0],
         2   [1,1,1]
        ]
        */
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {// 2, 0
                    //visited[i][j] = true;
                    int count = countNearestZero(mat, i, j);
                    System.out.println("positions [" + i + ", " + j + "] = " + count);
                    mat[i][j] = count;
                }
            }
        }
        return mat;
    }

    public static int countNearestZero(int[][] mat, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int count = 0;

        queue.add(new int[]{i, j});

        while (!queue.isEmpty()) {
            count++; //1
            int layer = queue.size(); //1
            while (layer > 0) {
                int[] position = queue.poll();
                int x = position[0]; //2
                int y = position[1]; //0

                if (mat[x][y] == 0) {
                    System.out.println(count + " position " + x + ", " + y + " = " + mat[x][y]);
                    return Math.max(0, count-1);
                }

                for (int idx = 0; idx < directions.length; idx++) {
                    int newX = x + directions[idx][0]; //2
                    int newY = y + directions[idx][1]; //1
                    if (newX >= 0 && newX < mat.length && newY >= 0 && newY < mat[newX].length) {
                        queue.add(new int[]{newX, newY}); //[1,0], [2,1]
                    }
                }
                layer--;
            }
        }
        return Math.max(0, count-1);
    }
}
