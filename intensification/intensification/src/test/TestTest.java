package test;

public class TestTest {

    public static void main(String[] args) {

        int i = testPlus((x, y) -> {System.out.println(123); return 1;}, 1, 2);
        System.out.println(i);
    }

    public static int testPlus( Test test, int x, int y) {
        return test.lambda(x, y);
    }
}
