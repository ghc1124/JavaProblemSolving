package baekjoon.no1712;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        int result = 0;
        if (C > B) {
            result = Math.floorDiv(A, C - B);
        }

        if (result > 0) {
            System.out.println(result + 1);
        } else {
            System.out.println(-1);
        }
    }

}
