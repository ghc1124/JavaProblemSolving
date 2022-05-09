package baekjoon.no11047;

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

        int[] coin = new int[N];
        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(reader.readLine());
        }

        int cnt = 0;

        for (int i = N - 1; i >= 0; i--) {
            if (coin[i] <= K) {
                cnt += K / coin[i];
                K %= coin[i];
            }
        }

        System.out.println(cnt);
    }

}
