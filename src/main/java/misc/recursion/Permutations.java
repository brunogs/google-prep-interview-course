package misc.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] distinct = new boolean[nums.length];
        permute(nums, distinct, result, new ArrayList<>());
        return result;
    }

    public void permute(int[] nums, boolean[] distinct, List<List<Integer>> result, List<Integer> partial) {
        if (partial.size() == nums.length) {
            result.add(List.copyOf(partial));
            return;
        }
        int[][] test = new int[nums.length][nums.length];
        Arrays.sort(test, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < nums.length; i++) {
            if (distinct[i]) {
                continue;
            }
            partial.add(nums[i]);
            distinct[i] = true;
            permute(nums, distinct, result, partial);
            partial.removeLast();
            distinct[i] = false;
        }
    }
}
