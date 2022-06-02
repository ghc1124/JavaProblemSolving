package swexpert.no1865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    private static double res;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());    // 테스트케이스

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(reader.readLine());    // 직원, 일의 수

            int[][] percent = new int[N][N];
            StringTokenizer tokenizer = null;
            for (int i = 0; i < N; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < N; j++) {
                    percent[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            res = 0;

            permutation(percent, new boolean[N], 1, N, 0);

            sb.append("#").append(t + 1).append(" ");
            sb.append(String.format("%.6f", res * 100)).append("\n");
        }

        System.out.println(sb);
    }

    private static void permutation(int[][] percent, boolean[] isVisited, double curr, int N, int cnt) {
        if (cnt == N) {
            res = Math.max(res, curr);
            return;
        }

        if (curr <= res) {
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isVisited[i]) {
                double temp = curr;
                isVisited[i] = true;
                curr *= percent[cnt][i] * 0.01;
                permutation(percent, isVisited, curr, N, cnt + 1);
                isVisited[i] = false;
                curr = temp;
            }
        }
    }

}
