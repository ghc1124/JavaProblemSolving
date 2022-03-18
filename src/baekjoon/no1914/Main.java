package baekjoon.no1914;

import java.util.Scanner;

public class Main {

    private static int count = 0;
    private static int N;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();

        hanoi(N, 1, 2, 3);
        System.out.println(count);
        if (N <= 20) {
            System.out.println(sb);
        }
    }

    private static void hanoi(int n, int from, int temp, int to) {
        if (n == 0) return;

        hanoi(n - 1, from, to, temp);
        if (N <= 20) {
            sb.append(from + " " + to).append("\n");
        }
        count++;
        hanoi(n - 1, temp, from, to);
    }

}
