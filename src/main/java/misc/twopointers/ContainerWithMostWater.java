package misc.twopointers;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int maximumAmount = 0;

        while (left < right) {
            int lowestHeight = Math.min(height[left], height[right]);
            int width = right - left;
            maximumAmount = Math.max(maximumAmount, lowestHeight * width);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maximumAmount;
    }

}
