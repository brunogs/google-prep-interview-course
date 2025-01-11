package misc.map;

import java.util.HashMap;
import java.util.Map;

public class ConstructKPalindromes {

    public boolean canConstruct(String s, int k) {
        if (s.length() < k) {
            return false;
        }
        if (s.length() == k) {
            return true;
        }

        Map<Character, Integer> counts = new HashMap<>();
        for (var c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        int countOdd = 0;
        for (var entry : counts.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                countOdd++;
            }
        }
        if (countOdd > k) {
            return false;
        }

        return true;
    }

}
