package misc.recursion;

public class UniquePath {

    Integer[][] memo;

    public int uniquePaths(int m, int n) {
        memo = new Integer[m][n];
        return findValidPath(0, 0, m, n);
    }

    private int findValidPath(int i, int j, int m, int n) {
        if (i >= m || j >= n) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (i == m-1 && j == n-1) {
            return 1;
        }

        int partial = findValidPath(i+1, j, m, n) + findValidPath(i, j+1, m, n);
        memo[i][j] = partial;
        return memo[i][j];
    }

}
