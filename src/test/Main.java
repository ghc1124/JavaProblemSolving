package test;

public class Main {

    public static void main(String[] args) {
        recur(1);
    }

    private static void recur(int i) {
        if (i == 6) {
            System.out.println();
            return;
        }

        System.out.print(i * 2 + 1 + " ");
        recur(i + 1);
        System.out.print(i * 2 + 1 + " ");
    }

}
