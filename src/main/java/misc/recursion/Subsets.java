package misc.recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        List<Integer> copy = new ArrayList<>();
        for (int n : nums) {
            copy.add(n);
        }

        result.add(copy);

        for (int i = nums.length-1; i > 0; i--) {
            boolean[] used = new boolean[nums.length];
            backtracking(nums, result, 0, i, new ArrayList<>(), used);

        }

        return result;
    }

    private void backtracking(int[] nums, List<List<Integer>> result, int start, int size, List<Integer> partial, boolean[] used) {
        if (partial.size() == size) {
            result.add(List.copyOf(partial));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            partial.add(nums[i]);
            used[i] = true;
            backtracking(nums, result, i+1, size, partial, used);
            partial.removeLast();
            used[i] = false;
        }
    }

}
