package lesson1;

import java.util.Deque;
import java.util.LinkedList;

import static precondition.Preconditions.check;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 *
 * <a href="https://leetcode.com/problems/trapping-rain-water/description/">Trapping Rain Water</a>
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int result = monotonicStack(height);
        check(result == 6);
        System.out.println(result);

        int[] height2 = {4,2,0,3,2,5};
        result = monotonicStack(height2);
        check(result == 9);
        System.out.println(result);
    }

    public static int monotonicStack(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        int water = 0;

        for (int i = 0; i < height.length; i++) {
            int currentHeight = height[i];
            while (!stack.isEmpty() && height[stack.peek()] < currentHeight) {
                int top = height[stack.pop()];
                if (!stack.isEmpty()) {
                    int maxLeft = height[stack.peek()];
                    int maxRight = height[i];
                    int width = i - stack.peek() - 1;
                    int wallHeight = Math.min(maxRight, maxLeft) - top;
                    water += wallHeight * width;
                }
            }
            stack.push(i);
        }
        return water;
    }
}
