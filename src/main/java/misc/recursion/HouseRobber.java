package misc.recursion;

public class HouseRobber {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        Integer[] memo = new Integer[nums.length];
        return rob(nums, 0, memo);
    }

    public static int rob(int[] nums, int n, Integer[] memo) {
        if (n >= nums.length) {
            return 0;
        }
        if (memo[n] != null) {
            return memo[n];
        }
        if (n == nums.length - 1) {
            return nums[n];
        }
        int partial = Math.max(rob(nums, n+1, memo), nums[n] + rob(nums, n+2, memo));
        memo[n] = partial;
        return partial;
    }
}
