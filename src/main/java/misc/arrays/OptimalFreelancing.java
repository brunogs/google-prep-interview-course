package misc.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.IntStream;

public class OptimalFreelancing {

    public int optimalFreelancing(Map<String, Integer>[] jobs) {
        Arrays.sort(jobs,
                Comparator.comparingInt((Map<String, Integer> a) -> a.get("payment")));

        int[] selecteds = new int[7];

        for (int i = jobs.length-1; i >= 0; i--) {
            var job = jobs[i];
            int deadline = job.get("deadline");
            int maxDay = Math.min(deadline-1, 6);
            if (selecteds[maxDay] == 0) {
                selecteds[maxDay] = job.get("payment");
            } else {

                for (int j = maxDay; j >= 0; j--) {
                    if (selecteds[j] == 0) {
                        selecteds[j] = job.get("payment");
                    }
                }
            }
        }
        return IntStream.of(selecteds).sum();
    }
}
