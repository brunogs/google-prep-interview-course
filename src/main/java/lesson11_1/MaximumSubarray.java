package lesson11_1;

public class MaximumSubarray {

    int total;

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int result = maximumSubarray.maxSubArray(nums);
        System.out.println(result);
    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 0) {
            return 0;
        }

        Integer[][] memo = new Integer[nums.length][nums.length];
        return maxSubArray(nums, 0, nums.length-1, memo);
    }

    public int maxSubArray(int[] nums, int start, int end, Integer[][] memo) {
        if (start == end) {
            return nums[start];
        }
        int half = (end + start) / 2;
        if (memo[start][end] == null) {
            int result = maxSubArray(nums, start, half, memo) + maxSubArray(nums, half+1, end, memo);
            total = Math.max(result, total);
            memo[start][end] = result;
        }
        return memo[start][end];
    }
}
