package lesson12;

public class UniquePathsII {

    private Integer[][] memo;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        memo = new Integer[obstacleGrid.length][obstacleGrid[0].length];
        return uniquePathsWithObstacles(obstacleGrid, 0, 0);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid, int x, int y) {
        int lastX = obstacleGrid.length - 1;
        int lastY = obstacleGrid[lastX].length - 1;

        if (x > lastX || y > lastY || obstacleGrid[x][y] != 0) {
            return 0;
        }

        if (memo[x][y] != null) {
            return memo[x][y];
        }

        if (x == lastX && y == lastY) {
            return 1;
        }

        // sum up path with right path
        int count = uniquePathsWithObstacles(obstacleGrid, x + 1, y) + uniquePathsWithObstacles(obstacleGrid, x, y + 1);
        memo[x][y] = count;
        return memo[x][y];
    }
}
