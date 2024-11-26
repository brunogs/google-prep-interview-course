package lesson3;

import java.util.LinkedList;

public class BinaryExample {

    public static void main(String[] args) {
        binary(new LinkedList<>(), 4);
    }

    public static void binary(LinkedList<Integer> partial, int n) {
        if (partial.size() == n) {
            System.out.println(partial);
            return;
        }

        for (int i = 0; i <= 1; i++) {
            partial.add(i);
            binary(partial, n);
            partial.removeLast();
        }
    }
}
