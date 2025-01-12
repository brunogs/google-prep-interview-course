package misc.stack;

import java.util.Deque;
import java.util.LinkedList;

public class CheckParenthesisStringCanBeValid {

    public boolean canBeValid(String s, String locked) {
        if (s.length() <= 1 || s.length() % 2 != 0) {
            return false;
        }
        Deque<Integer> opening = new LinkedList<>();
        Deque<Integer> unlocked = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '0') {
                unlocked.push(i);
            } else if (s.charAt(i) == '(') {
                opening.push(i);
            } else if (s.charAt(i) == ')') {
                if (!opening.isEmpty()) {
                    opening.pop();
                } else if (!unlocked.isEmpty()) {
                    unlocked.pop();
                } else {
                    return false;
                }
            }
        }

        while (!opening.isEmpty() && !unlocked.isEmpty() && opening.peek() < unlocked.peek()) {
            opening.pop();
            unlocked.pop();
        }

        return opening.isEmpty();
    }
}
