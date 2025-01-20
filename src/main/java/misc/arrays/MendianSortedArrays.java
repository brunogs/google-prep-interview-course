package misc.arrays;

import java.util.PriorityQueue;

public class MendianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {0,0,0,0,0};
        int[] nums2 = {-1,0,0,0,0,0,1};

        double result = findMedianSortedArrays(nums1, nums2);

        System.out.println(result);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        PriorityQueue<Integer> left = new PriorityQueue<>((a,b) -> Integer.compare(b, a));//reverse, greater to lower
        PriorityQueue<Integer> right = new PriorityQueue<>();// natural, lower to greater

        for (int i : nums1) {
            left.offer(i);
        }

        for (int i : nums2) {
            right.offer(i);
        }

        while ((!left.isEmpty() && !right.isEmpty() && (left.peek() > right.peek()) || Math.abs(left.size() - right.size()) > 1)) {
            if (left.size() > right.size()) {
                right.offer(left.poll());
            } else if (right.size() > left.size()) {
                left.offer(right.poll());
            } else {
                // if same size lets move the greater move to right or the
                right.offer(left.poll());
            }

        }

        if (left.size() > right.size()) {
            return (double)left.poll();
        }
        if (right.size() > left.size()) {
            return (double)right.poll();
        }
        return ((double) (left.peek() + right.peek()) / 2);

    }
}
