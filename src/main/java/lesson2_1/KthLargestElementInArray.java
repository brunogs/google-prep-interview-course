package lesson2_1;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class KthLargestElementInArray {

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};

        int result = findKthLargest(nums, 2);

        System.out.println(result);
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(nums.length, Comparator.reverseOrder());

        var numsList = IntStream.of(nums).boxed().toList();

        heap.addAll(numsList);

        while (k > 1) {
            heap.poll();
            k--;
        }
        return heap.poll();
    }
}
