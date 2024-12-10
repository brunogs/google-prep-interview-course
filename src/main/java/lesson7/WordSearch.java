package lesson7;

public class WordSearch {

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};

        boolean result = exist(board, "ABCCED");

        System.out.println(result);
    }

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (findWord(board, i, j, 0, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean findWord(char[][] board, int x, int y, int wordIdx, String word) {
        System.out.println(wordIdx);
        System.out.println("posições " + x + " _ " + y);
        if (wordIdx == word.length()) {
            return true;
        }
        if (x < 0 || x > board.length-1 || y < 0 || y > board[x].length-1 || board[x][y] != word.charAt(wordIdx)) {
            return false;
        }

        char oldChar = board[x][y];
        board[x][y] = '0';

        int up = x-1;
        if (findWord(board, up, y, wordIdx+1, word)) {
            return true;
        }
        int down = x+1;
        if (findWord(board, down, y, wordIdx+1, word)) {
            return true;
        }
        int right = y+1;
        if (findWord(board, x, right, wordIdx+1, word)) {
            return true;
        }
        int left = y-1;
        if (findWord(board, x, left, wordIdx+1, word)) {
            return true;
        }
        board[x][y] = oldChar;
        return false;
    }
}
