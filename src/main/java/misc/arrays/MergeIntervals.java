package misc.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals == null) {
            return null;
        }

        List<int[]> output = new ArrayList<>();

        // O (nlogn)
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        output.add(intervals[0]);
        int[]lastAdded = intervals[0];

        // O (n)
        for (int i = 1; i < intervals.length; i++) {
            // current begin is greater than previous end
            if (intervals[i][0] > lastAdded[1]) {
                output.add(intervals[i]);
                lastAdded = intervals[i];
            }  else {
                int start = Math.min(intervals[i][0], lastAdded[0]);
                int end = Math.max(intervals[i][1], lastAdded[1]);
                int[] merge = new int[]{start, end};
                output.set(Math.min(i-1, output.size()-1), merge);
                lastAdded = merge;
            }
        }

        return convertOutput(output);
    }

    private int[][] convertOutput(List<int[]> output) {
        int[][] result = new int[output.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i] = output.get(i);
        }
        return result;
    }
}
