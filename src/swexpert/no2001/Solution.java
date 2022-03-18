package swexpert.no2001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(reader.readLine());
        int problemNum = 1;

        while (testCase-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int N = Integer.parseInt(tokenizer.nextToken()); // 배열 크기
            int M = Integer.parseInt(tokenizer.nextToken()); // 파리채 크기

            int result = 0;
            int[][] matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            for (int i = 0; i <= N - M; i++) {
                for (int j = 0; j <= N - M; j++) {
                    int temp = 0;
                    for (int k = 0; k < M; k++) {
                        for (int l = 0; l < M; l++) {
                            temp += matrix[i + k][j + l];
                        }
                    }
                    result = Math.max(temp, result);
                }
            }
            sb.append("#").append(problemNum++).append(" ");
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

}
