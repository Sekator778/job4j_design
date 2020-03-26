package myio;

public class AssertDemo {
    static int x = 3;
    static int getX() {
        return x--;
    }

    public static void main(String[] args) {
        int n;
        for (int i = 0; i < 10; i++) {
            n = getX();
            assert n > 0;
            System.out.println("n equally: " + n);
        }
    }
}
