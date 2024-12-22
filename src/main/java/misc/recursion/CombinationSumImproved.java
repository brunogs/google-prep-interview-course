package misc.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumImproved {

    /*
    cleaner and better approach, it's still a backtracking approach but I'm saving memory and time
    no soring, and no extra copies
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(candidates, target, 0, result, 0, new ArrayList<>());
        return result;
    }

    public void backtracking(int[] candidates, int target, int start, List<List<Integer>> result, int total, List<Integer> partial) {
        if (total == target) {
            List<Integer> copy = new ArrayList<>(partial);
            result.add(copy);
            return;
        }
        if (total > target || start >= candidates.length) {
            return;
        }

        partial.add(candidates[start]);
        backtracking(candidates, target, start, result, total + candidates[start], partial);
        partial.removeLast();
        backtracking(candidates, target, start + 1, result, total, partial);
    }

}
