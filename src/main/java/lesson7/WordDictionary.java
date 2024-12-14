package lesson7;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WordDictionary {

    Map<Character, WordDictionary> childs;
    boolean wordEnd;

    public WordDictionary() {
        this.childs = new HashMap<>();
    }
    
    public void addWord(String word) {
        var current = this;

        for (var c : word.toCharArray()) {
            current.childs.computeIfAbsent(c, k -> new WordDictionary());
            current = current.childs.get(c);
        }

        current.wordEnd = true;
    }
    
    //.pnneostllnnma
    public boolean search(String word) {
        Deque<List<WordDictionary>> stack = new LinkedList<>();
        stack.push(List.of(this));
        int i = 0;

        while (!stack.isEmpty() && i < word.length()) {

            if (word.charAt(i) != '.') {
                List<WordDictionary> items = stack.pop();
                List<WordDictionary> options = new ArrayList<>();
                for (var it : items) {
                    if (it.childs.keySet().contains(word.charAt(i))) {
                        options.add(it.childs.get(word.charAt(i)));
                    }
                }
                if (options.isEmpty()) {
                    return false;
                }
                stack.push(options);
                i++;
            } else if (word.charAt(i) == '.') {
                List<WordDictionary> items = stack.pop();
                List<WordDictionary> options = new ArrayList<>();
                for (var it : items) {
                    for (var child : it.childs.values()) {
                        options.add(child);
                    }
                }
                stack.push(options);
                i++;
            }
        }

        if (stack.isEmpty()) {
            return false;
        }
        List<WordDictionary> results = stack.peek();
        for (var r : results) {
            if (r.wordEnd) {
                return true;
            }
        }
        return false;
    }
}