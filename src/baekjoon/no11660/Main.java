package baekjoon.no11660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        int[][] arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int x1 = Integer.parseInt(tokenizer.nextToken());
            int y1 = Integer.parseInt(tokenizer.nextToken());
            int x2 = Integer.parseInt(tokenizer.nextToken());
            int y2 = Integer.parseInt(tokenizer.nextToken());

            int res = 0;

            for (int j = x1; j <= x2; j++) {
                for (int k = y1; k <= y2; k++) {
                    res += arr[j][k];
                }
            }

            sb.append(res).append("\n");
        }

        System.out.println(sb);
    }

}
