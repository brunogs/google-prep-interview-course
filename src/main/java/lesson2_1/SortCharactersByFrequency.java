package lesson2_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.
 *
 * Return the sorted string. If there are multiple answers, return any of them.
 */
public class SortCharactersByFrequency {

    public static void main(String[] args) {
        String s = "tree";

        String result = frequencySortHeap(s);

        System.out.println(result);
    }

    public static String frequencySortHeap(String s) {

        Map<Character, String> lettersByChar = new HashMap<>();

        PriorityQueue<Character> heap = new PriorityQueue(
                s.length(),
                (i, j) -> Integer.compare(lettersByChar.getOrDefault(j, "").length(), lettersByChar.getOrDefault(i, "").length())
        );

        for (char it : s.toCharArray()) {
            lettersByChar.compute(it, (k, v) -> (v == null) ? it+"" : v + "" + it);
        }



        heap.addAll(lettersByChar.keySet());

        String out = "";
        while (!heap.isEmpty()) {
            char current = heap.poll();
            String letters = lettersByChar.get(current);
            out += letters;
        }

        return out;
    }

    public static String frequencySortHashAndSort(String s) {
        Map<Character, String> lettersByChar = new HashMap<>();

        for (char it : s.toCharArray()) {
            lettersByChar.compute(it, (k, v) -> (v == null) ? it+"" : v + "" + it);
        }

        String out = lettersByChar.entrySet().stream()
                .sorted(Map.Entry.comparingByValue((i, j) -> Integer.compare(j.length(), i.length())))
                .map(Map.Entry::getValue)
                .reduce((acc, cur) -> acc + cur)
                .orElse("");

        return out;
    }
}
