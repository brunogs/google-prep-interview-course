package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum {

    private Set<List<Integer>> combinations = new HashSet<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(candidates, target, result, new ArrayList<>());
        return result;
    }

    public void backtracking(int[] candidates, int target, List<List<Integer>> result, List<Integer> partial) {
        if (combinations.contains(partial)) {
            return;
        }
        int current = sum(partial);
        if (current == target) {
            List<Integer> copy = new ArrayList<>(partial);
            copy.sort(Integer::compareTo);
            if (!combinations.contains(copy)) {
                result.add(copy);
                combinations.add(copy);
            }
            return;
        }
        if (current > target) {
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            partial.add(candidates[i]);
            backtracking(candidates, target, result, partial);
            partial.remove(partial.size()-1);
        }
    }

    public int sum(List<Integer> values) {
        int sum = 0;
        for (int n : values) {
            sum += n;
        }
        return sum;
    }
}
