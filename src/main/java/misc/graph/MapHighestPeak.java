package misc.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MapHighestPeak {

    public static void main(String[] args) {
        //int[][] input = {{0,1},{0,0}};
        int[][] input = {{0,0,1},{1,0,0},{0,0,0}};
        System.out.println(Arrays.deepToString(highestPeak(input)));
    }

    public static int[][] highestPeak(int[][] isWater) {
        /*
        [
            [0,1],
            [0,0]]
        */
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean[][] water = new boolean[isWater.length][isWater[0].length];

        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[i].length; j++) {
                if (isWater[i][j] == 1) {
                    q.add(new int[]{i, j});
                    water[i][j] = true;
                }
            }
        }

        // q = (0,0)

        int height = 0; //1
        while (!q.isEmpty()) {
            int size = q.size();
            System.out.println("consuming queue " + q);
            while (size > 0) {
                int[] current = q.poll();

                int i = current[0];
                int j = current[1];

                if (isWater[i][j] > 0 && !water[i][j]) {
                    size--;
                    continue;
                }

                isWater[i][j] = height;

                for (var dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];

                    System.out.println("checking " + x + " " + y);

                    if (x < 0 || x >= isWater.length) continue;
                    if (y < 0 || y >= isWater[x].length) continue;

                    System.out.println("having value " + isWater[x][j]);
                    if (isWater[x][y] > 0) continue;
                    System.out.println("is water " + water[x][j]);
                    if (water[x][y]) continue;

                    q.add(new int[]{x, y});
                }
                size--;
            }
            height++;
        }
        return isWater;
    }
}
