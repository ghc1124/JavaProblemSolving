package baekjoon.no1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        int[][] DP = new int[N][3]; // 0: R, 1: G, 2: B

        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int R = Integer.parseInt(tokenizer.nextToken());
            int G = Integer.parseInt(tokenizer.nextToken());
            int B = Integer.parseInt(tokenizer.nextToken());

            DP[i][0] = R;
            DP[i][1] = G;
            DP[i][2] = B;
        }

        for (int i = 1; i < N; i++) {
            DP[i][0] += Math.min(DP[i - 1][1], DP[i - 1][2]);
            DP[i][1] += Math.min(DP[i - 1][0], DP[i - 1][2]);
            DP[i][2] += Math.min(DP[i - 1][0], DP[i - 1][1]);
        }

        System.out.println(Math.min(DP[N - 1][0], Math.min(DP[N - 1][1], DP[N - 1][2])));
    }

}
