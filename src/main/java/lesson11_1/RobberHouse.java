package lesson11_1;

public class RobberHouse {

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        var result = rob(nums);
        System.out.println(result);
    }

    public static int rob(int[] nums) {
        return rob(nums, nums.length - 1);
    }

    public static int rob(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        return Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
    }
}
