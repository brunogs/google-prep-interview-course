package lesson1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;

        int[] result = mapSolution(nums, target);
        System.out.println(Arrays.toString(result));
        //TODO check results
    }

    //TODO brute force


    //O(n)
    public static int[] mapSolution(int[] nums, int target) {
        Map<Integer, Integer> positionByValue = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int diff = target - current;

            Integer result = positionByValue.get(diff);
            if (result != null) {
                return new int[]{i, result};
            } else {
                positionByValue.put(current, i);
            }
        }
        return new int[]{0, 0};
    }
}

