package baekjoon.no2609;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        System.out.println(gcd(N, M));
        System.out.println(N * M / gcd(N, M));
    }

    private static int gcd(int N, int M) {
        if (M == 0) {
            return N;
        }

        int temp = N;
        N = M;
        M = temp % M;
        return gcd(N, M);
    }

}
