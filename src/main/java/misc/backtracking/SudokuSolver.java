package misc.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SudokuSolver {

    public static void main(String[] args) {
        char[][] board = {
            {'.','.','9','7','4','8','.','.','.'},
            {'7','.','.','.','.','.','.','.','.'},
            {'.','2','.','1','.','9','.','.','.'},
            {'.','.','7','.','.','.','2','4','.'},
            {'.','6','4','.','1','.','5','9','.'},
            {'.','9','8','.','.','.','3','.','.'},
            {'.','.','.','8','.','3','.','2','.'},
            {'.','.','.','.','.','.','.','.','6'},
            {'.','.','.','2','7','5','9','.','.'}
        };

        solveSudoku(board);

        for (var it : board) {
            System.out.println(Arrays.toString(it));
        }

    }

    public static void solveSudoku(char[][] board) {
        // create array of rows
        // array of columns

        // map of sets, each key (r + c) => (set of subgrid)

        List<Set<Integer>> columnSets = new ArrayList<>();
        List<Set<Integer>> rowSets = new ArrayList<>();
        List<List<Set<Integer>>> subgrid = new ArrayList<>();

        List<int[]> emptyCells = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    emptyCells.add(new int[]{i,j});
                    continue;
                }
                if (columnSets.size() <= i) {
                    columnSets.add(new HashSet<>());
                }
                Integer intValue = Integer.valueOf(board[i][j]+ "");
                columnSets.get(i).add(intValue);
                while (rowSets.size() <= j) {
                    rowSets.add(new HashSet<>());
                }
                rowSets.get(j).add(intValue);

                int x = (i / 3);
                int y = (j / 3);

                while (subgrid.size() <= x) {
                    subgrid.add(new ArrayList<>());
                }
                while (subgrid.get(x).size() <= y) {
                    subgrid.get(x).add(new HashSet<>());
                }
                subgrid.get(x).get(y).add(intValue);
            }
        }

        backtracking(board, columnSets, rowSets, subgrid, emptyCells, 1);
    }

    private static void backtracking(
            char[][] board,
            List<Set<Integer>> columnSets,
            List<Set<Integer>> rowSets,
            List<List<Set<Integer>>> subgrid,
            List<int[]> emptyCells,
            int next
    ) {

        if (emptyCells.isEmpty()) {
            return;
        }

        if (next > 9) {
            return;
        }

        int[] currentCell = emptyCells.removeFirst();

        int i = currentCell[0];
        int j = currentCell[1];

        int x = (i / 3);
        int y = (j / 3);

        if (canAdd(next, columnSets, rowSets, subgrid, i, j)) {
            board[i][j] = (char)(next + '0');
            columnSets.get(i).add(next);
            rowSets.get(j).add(next);
            subgrid.get(x).get(y).add(next);

            backtracking(board, columnSets, rowSets, subgrid, emptyCells, 1);

            if (!emptyCells.isEmpty()) {
                columnSets.get(i).remove(next);
                rowSets.get(j).remove(next);
                subgrid.get(x).get(y).remove(next);
                emptyCells.addFirst(currentCell);
                backtracking(board, columnSets, rowSets, subgrid, emptyCells, next+1);
            }
        } else {
            emptyCells.addFirst(currentCell);
            backtracking(board, columnSets, rowSets, subgrid, emptyCells, next + 1);
        }

    }

    private static boolean canAdd(
            int value,
            List<Set<Integer>> columnSets,
            List<Set<Integer>> rowSets,
            List<List<Set<Integer>>> subgrid,
            int i, int j
    ) {
        if (value > 9)
            return false;
        while (columnSets.size() <= i)
            columnSets.add(new HashSet<>());

        if (columnSets.get(i).contains(value))
            return false;

        while (rowSets.size() <= j)
            rowSets.add(new HashSet<>());

        if (rowSets.get(j).contains(value))
            return false;
        int x = (i / 3);
        int y = (j / 3);
        //fix subgrid size
        while (subgrid.size() <= x) {
            subgrid.add(new ArrayList<>());
        }
        while (subgrid.get(x).size() <= y) {
            subgrid.get(x).add(new HashSet<>());
        }
        if (subgrid.get(x).get(y).contains(value))
            return false;
        return true;
    }
}
