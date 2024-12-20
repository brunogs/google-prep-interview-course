package lesson12;

import java.util.Arrays;

public class Lis {

    class Solution {

        Integer[] memo;
        int max = 0;

        public int lengthOfLIS(int[] nums) {
            return lengthOfLISIter(nums);
        }

        // iterativa
        public int lengthOfLISIter(int[] nums) {
            memo = new Integer[nums.length];
            memo[nums.length-1] = 1;
            for (int i = nums.length-1; i >= 0; i--) {
                int maxSequence = 0;
                for (int j = i+1; j < nums.length; j++) {
                    if (nums[j] > nums[i]) {
                        maxSequence = Math.max(maxSequence, memo[j]);
                    }
                    memo[i] = 1 + maxSequence;
                }
            }
            System.out.println(Arrays.toString(memo));
            int max = Integer.MIN_VALUE;
            for (Integer n : memo) {
                if (n != null)
                    max = Math.max(n, max);
            }
            return max;
        }

        // recursive
        public int lengthOfLISRec(int[] nums) {
            memo = new Integer[nums.length];
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                max = Math.max(max, lengthOfLISRec(nums, i));
            }
            return max;
        }

        public int lengthOfLISRec(int[] nums, int end) {
            if (memo[end] != null) {
                return memo[end];
            }
            int maxLength = 1;
            for (int i = 0; i < end; i++) {
                if (nums[i] < nums[end]) {
                    maxLength = Math.max(maxLength, 1 + lengthOfLISRec(nums, i));
                }
            }
            memo[end] = maxLength;
            return maxLength;
        }
    }
}
