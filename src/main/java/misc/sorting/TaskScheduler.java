package misc.sorting;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> charCount = new HashMap<>();

        int total = 0;
        for (var ch : tasks) {
            int count = charCount.getOrDefault(ch, 0);
            charCount.put(ch, count + 1);
            total++;
        }

        PriorityQueue<Character> heap = new PriorityQueue<>((a, b) -> Integer.compare(charCount.get(b), charCount.get(a)));
        for (var ch : charCount.keySet()) {
            heap.offer(ch);
        }

        int count = 0;

        while (!heap.isEmpty()) {

            Deque<Character> removedItems = new LinkedList<>();
            int intervals = n + 1;

            while (intervals > 0 && total > 0) {
                count++;
                if (!heap.isEmpty()) {
                    var ch = heap.poll();
                    int charTotal = charCount.get(ch);
                    charCount.put(ch, charTotal - 1);
                    removedItems.add(ch);
                    total--;
                }
                intervals--;
            }

            while (!removedItems.isEmpty()) {
                var key = removedItems.pop();
                if (charCount.getOrDefault(key, 0) > 0) {
                    heap.offer(key);
                }
            }
        }

        return count;
    }
}
