package lesson3_1;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        var result = combine(n, k);

        System.out.println(result);
    }

    public static void combineAux(int start, int n, int k, List<Integer> partial, List<List<Integer>> result) {
        if (partial.size() == k) {
            result.add(List.copyOf(partial));
            return;
        }

        for (int i = start; i <= n; i++) {
            if ((partial.isEmpty() || partial.get(partial.size()-1) < i)) {
                partial.add(i);
                combineAux(start+1, n, k, partial, result);
                partial.remove((Integer)i);
            }
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        var result = new ArrayList<List<Integer>>();
        combineAux(1, n, k, new ArrayList<>(), result);
        return result;
    }
}
