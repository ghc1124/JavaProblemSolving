package baekjoon.no13300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());
        int[][] students = new int[2][7]; // 행: 성별, 열: 학년
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            students[Integer.parseInt(tokenizer.nextToken())][Integer.parseInt(tokenizer.nextToken())]++;
        }

        int result = 0;

        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < 7; j++) {
                result += (int) Math.ceil(1.0 * students[i][j] / K);
            }
        }

        System.out.println(result);
    }

}
