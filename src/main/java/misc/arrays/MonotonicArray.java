package misc.arrays;

import java.util.Deque;
import java.util.LinkedList;

public class MonotonicArray {

    public static boolean isMonotonic(int[] array) {
        if (array.length <= 1)
            return true;
        Deque<Integer> stack = new LinkedList<>();

        int start = 0;
        while (start+1 < array.length-1 && array[start] == array[start+1]) {
            start++;
        }
        boolean isIncreasing = array[start] < array[start+1];
        stack.push(array[start]);

        for (int i = start+1; i < array.length; i++) {
            if (isIncreasing && array[i] < stack.peek()) {
                return false;
            }
            if (!isIncreasing && array[i] > stack.peek()) {
                return false;
            }
            stack.push(array[i]);
        }

        return true;
    }
}
