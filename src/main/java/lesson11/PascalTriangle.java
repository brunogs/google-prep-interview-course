package lesson11;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args) {
        var result = generate(5);

        for (var row : result) {
            System.out.println(row);
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int row = 0; row < numRows; row++) {
            List<Integer> thisRow = new ArrayList<>();
            // 0 - 2
            for (int i = 0; i < row+1; i++) {
                thisRow.add(1); //[1,1]
            }
            for (int i = 1; i < row; i++) {
                var parent = result.get(row-1);
                int newValue = parent.get(i-1)+parent.get(i);
                thisRow.set(i, newValue);
            }
            result.add(thisRow); // [[1],]
        }
        return result;
    }
}
