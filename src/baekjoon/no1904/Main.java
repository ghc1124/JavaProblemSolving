package baekjoon.no1904;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.close();

        int[] arr = new int[N + 1];
        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i <= N; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 15746;
        }

        System.out.println(arr[N]);
    }

}
