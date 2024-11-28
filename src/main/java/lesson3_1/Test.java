package lesson3_1;

public class Test {

    public static void main(String[] args) {
        var out = "A man, a plan, a canal: Panama".replaceAll(" ", "").toLowerCase().replaceAll("[^a-z0-9]", "");
        System.out.println(out);
    }
}
