package misc.arrays;

import java.util.Arrays;

public class MinimumWaitingTime {

    public int minimumWaitingTime(int[] queries) {
        if (queries.length <= 1) return 0;

        Arrays.sort(queries);

        int[] waitTime = new int[queries.length];
        int acc = 0;

        for (int i = 1; i < queries.length; i++) {
            acc += queries[i-1];
            waitTime[i] = acc;
        }

        int total = 0;
        for (int v : waitTime)
            total += v;
        return total;
    }

}
