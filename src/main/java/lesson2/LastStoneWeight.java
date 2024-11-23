package lesson2;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * You are given an array of integers stones where stones[i] is the weight of the ith stone.
 *
 * We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:
 *
 * If x == y, both stones are destroyed, and
 * If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
 * At the end of the game, there is at most one stone left.
 *
 * Return the weight of the last remaining stone. If there are no stones left, return 0.
 */
public class LastStoneWeight {

    public static void main(String[] args) {
        int[] stones = {1,3};
        int out = heap(stones);

        System.out.println(out);
    }

    // O (n logn)
    public static int heap(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < stones.length; i++) {
            heap.add(stones[i]);
        }
        while (heap.size() > 1) {
            int greatest = heap.poll();
            if (heap.isEmpty()) {
                break;
            }
            int second = heap.poll();

            if (greatest != second) {
                int result = greatest - second;
                heap.add(result);
            }
        }

        return heap.isEmpty() ? 0 : heap.poll();
    }
}
