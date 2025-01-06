package lesson13;

import java.util.HashMap;
import java.util.Map;

public class PredictWinner {

    static record Pair(int left, int right){}

    private Map<Pair, Integer> memo = new HashMap<>();

    public boolean predictTheWinner(int[] nums) {
        return predictTheWinner(nums, 0, nums.length-1) >= 0;
    }

    public int predictTheWinner(int[] nums, int left, int right) {

        var pair = new Pair(left, right);

        var resultFound = memo.get(pair);
        if (resultFound != null) {
            return resultFound;
        }

        if (left == right) {
            memo.put(pair, nums[left]);
            return nums[left];
        }

        int leftResult = nums[left] - predictTheWinner(nums, left + 1, right);
        int rightResult = nums[right] - predictTheWinner(nums, left, right - 1);

        int partialResult = Math.max(leftResult, rightResult);

        memo.put(pair, partialResult);

        return partialResult;
    }

}
