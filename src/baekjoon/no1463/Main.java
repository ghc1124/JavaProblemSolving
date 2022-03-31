package baekjoon.no1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        int[] DP = new int[N + 1]; // DP 테이블

        for (int i = 2; i <= N; i++) {
            int min = 1 + DP[i - 1];
            if (i % 3 == 0 && 1 + DP[i / 3] < min) min = 1 + DP[i / 3];
            if (i % 2 == 0 && 1 + DP[i / 2] < min) min = 1 + DP[i / 2];

            DP[i] = min;
        }

        System.out.println(DP[N]);
    }

}
