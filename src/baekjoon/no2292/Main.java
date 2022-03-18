package baekjoon.no2292;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int temp = 1;
        int result = 1;

        while (temp < N) {
            temp += 6 * result++;
        }

        System.out.println(result);
    }

}