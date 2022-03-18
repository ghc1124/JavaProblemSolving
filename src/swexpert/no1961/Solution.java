package swexpert.no1961;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine()); // 테케 개수

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[N][N];
            for (int j = 0; j < N; j++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int k = 0; k < N; k++) {
                    matrix[j][k] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            sb.append("#").append(i + 1).append("\n");

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    sb.append(matrix[N - k - 1][j]);
                }

                sb.append(" ");

                for (int k = 0; k < N; k++) {
                    sb.append(matrix[N - j - 1][N - k - 1]);
                }

                sb.append(" ");

                for (int k = 0; k < N; k++) {
                    sb.append(matrix[k][N - j - 1]);
                }

                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

}
