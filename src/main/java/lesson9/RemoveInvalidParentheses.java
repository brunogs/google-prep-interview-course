package lesson9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class RemoveInvalidParentheses {

    public List<String> removeInvalidParentheses(String s) {
        return removeInvalidParenthesesDfs(s);
    }

    public boolean isValid(String s) {
        int openParentheses = 0;
        for (var c : s.toCharArray()) {
            if (c == '(') {
                openParentheses++;
            } else if (c == ')') {
                openParentheses--;
                if (openParentheses < 0) {
                    return false;
                }
            }
        }
        return openParentheses == 0;
    }

    public Set<String> neighs(String s) {
        Set<String> result = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                String partial = i > 0 ? s.substring(0, i) : "";
                partial += s.substring(i+1);
                result.add(partial);
            }
        }

        return result;
    }

    public List<String> removeInvalidParenthesesDfs(String s) {

        if (isValid(s)) {
            return List.of(s);
        }

        Set<String> discovered = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        discovered.add(s);

        while (!queue.isEmpty()) {
            var size = queue.size();
            var result = new ArrayList<String>();
            while (size > 0) {
                var node = queue.poll();
                if (isValid(node)) {
                    result.add(node);
                }
                for (var neight : neighs(node)) {
                    if (!discovered.contains(neight)) {
                        queue.add(neight);
                        discovered.add(neight);
                    }
                }
                size--;
            }
            if (!result.isEmpty()) {
                return result;
            }
        }
        return List.of("");
    }
}
