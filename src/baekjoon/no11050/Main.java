package baekjoon.no11050;

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

        int result = 1;

        for (int i = N; i > N - K; i--) {
            result *= i; // 분자
        }

        int temp = 1;

        for (int i = 1; i <= K; i++) {
            temp *= i; // 분모
        }

        System.out.println(result / temp);
    }

}
