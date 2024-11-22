package lesson1;

import precondition.Preconditions;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import static precondition.Preconditions.check;

/**
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 */
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = monotonicQueue(nums, k);
        check(Arrays.equals(result, new int[]{3, 3, 5, 5, 6, 7}));
        System.out.println(Arrays.toString(result));

        result = bruteForce(nums, k);
        check(Arrays.equals(result, new int[]{3, 3, 5, 5, 6, 7}));
        System.out.println(Arrays.toString(result));
    }

    // O (n)
    public static int[] monotonicQueue(int[] nums, int k) {
        int[] out = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        int outIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);

            if (i >= k-1) {
                out[outIndex] = nums[deque.peekFirst()];
                outIndex++;
            }
        }
        return out;
    }

    // O (n^k)
    private static int[] bruteForce(int[] nums, int k) {
        int[] out = new int[nums.length - k + 1];
        int outIndex = 0;
        for (int i = 0; i < nums.length - (k - 1); i++) {
            int windowLargest = -9999;

            for (int j = i; j < i + k; j++) {
                windowLargest = Math.max(windowLargest, nums[j]);
            }
            out[outIndex] = windowLargest;
            outIndex++;
        }
        return out;
    }
}
