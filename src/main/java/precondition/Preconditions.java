package precondition;

public class Preconditions {

    public static void check(boolean expression) {
        if (!expression) {
            throw new IllegalArgumentException("Result invalid");
        }
    }
}
