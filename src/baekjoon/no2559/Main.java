package baekjoon.no2559;

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
        tokenizer = new StringTokenizer(reader.readLine());
        int[] temp = new int[N];
        for (int i = 0; i < N; i++) {
            temp[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int answer = Integer.MIN_VALUE;

        int sum = 0;

        // 최초 합
        for (int i = 0; i < K; i++) {
            sum += temp[i];
        }

        answer = Math.max(answer, sum);

        for (int i = 1; i <= N - K; i++) {
            sum = sum - temp[i - 1] + temp[i + (K - 1)];
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }

}
