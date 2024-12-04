package lesson4_1;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class FloodFill {

    public static void main(String[] args) {
        int[][] image = {{2,2,2},{2,2,0},{2,0,1}};
        int sr = 1, sc = 1, color = 2;

        int[][] imageResult = floodFill(image, sr, sc, color);
        for (int i = 0; i < imageResult.length; i++) {
            System.out.println(Arrays.toString(imageResult[i]));
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];

        if (originalColor == color) {
            return image;
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


        Deque<int[]> stack = new LinkedList<>();
        stack.add(new int[]{sr, sc});

        while (!stack.isEmpty()) {

            int[] position = stack.pop();

            int x = position[0];
            int y = position[1];

            image[x][y] = color;

            for (int i = 0; i < directions.length; i++) {
                int newX = x + directions[i][0];
                int newY = y + directions[i][1];

                if (newX >= 0 && newX < image.length && newY >= 0 && newY < image[newX].length) {
                    if (image[newX][newY] == originalColor) {
                        stack.add(new int[]{newX, newY});
                    }
                }
            }
        }

        return image;
    }
}
