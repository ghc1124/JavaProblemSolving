package baekjoon.no14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine()); // 일수
        int[][] pay = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            pay[i][0] = Integer.parseInt(tokenizer.nextToken());
            pay[i][1] = Integer.parseInt(tokenizer.nextToken());
        }

        int[] dp = new int[N + 1];

        for (int i = N - 1; i >= 0; i--) {
            if (i + pay[i][0] <= N) dp[i] = Math.max(pay[i][1] + dp[i + pay[i][0]], dp[i + 1]);
            else dp[i] = dp[i + 1];
        }

        System.out.println(dp[0]);
    }

}
