package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum {

    private Set<List<Integer>> combinations = new HashSet<>();

    /*
    this approach is bad because i'm using extra memory to check unique combinations, and in order to have sure it's unique I'm also sorting the combination
    it means more O(N) of memory and extra O(nlogn) for each iteration
     */
    public List<List<Integer>> combinationSumBruteForce(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrackingBruteForce(candidates, target, result, new ArrayList<>());
        return result;
    }

    public void backtrackingBruteForce(int[] candidates, int target, List<List<Integer>> result, List<Integer> partial) {
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
            backtrackingBruteForce(candidates, target, result, partial);
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
