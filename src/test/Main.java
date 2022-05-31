package test;

public class Main {

    public static void main(String[] args) {
        recursive("ASADADAS", 0);
    }

    private static void recursive(String target, int index) {
        if (index == target.length()) {
            return;
        }

        System.out.print(target.charAt(index));
        recursive(target, index + 1);
        System.out.print(target.charAt(index));
    }

}
