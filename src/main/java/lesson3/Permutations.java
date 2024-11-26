package lesson3;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of distinct integers, return all the possible
 * permutations
 * . You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 */
public class Permutations {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> result = permute(nums);

        System.out.println(result);
    }

    public static void permuteAux(int[] nums, List<Integer> partial, List<List<Integer>> result, boolean[] used) {
        if (partial.size() == nums.length) {
            result.add(List.copyOf(partial));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                partial.add(nums[i]);
                used[i] = true;
                permuteAux(nums, partial, result, used);
                used[i] = false;
                partial.remove((Integer)nums[i]);
            }
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        var result = new ArrayList<List<Integer>>();
        boolean[] used = new boolean[nums.length];
        permuteAux(nums, new ArrayList<>(), result, used);
        return result;
    }
}
