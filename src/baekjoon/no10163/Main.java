package baekjoon.no10163;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        StringBuilder sb = new StringBuilder();

        int[][] paper = new int[1001][1001];
        int[] count = new int[N + 1];

        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int col = Integer.parseInt(tokenizer.nextToken());
            int row = Integer.parseInt(tokenizer.nextToken());
            int width = Integer.parseInt(tokenizer.nextToken());
            int height = Integer.parseInt(tokenizer.nextToken());

            for (int j = row; j < row + height; j++) {
                for (int k = col; k < col + width; k++) {
                    paper[j][k] = i + 1;
                }
            }
        }

        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 1001; j++) {
                count[paper[i][j]]++;
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(count[i]).append("\n");
        }

        System.out.println(sb);
    }

}
