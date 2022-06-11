package baekjoon.no4158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = null;

        while (true) {
            tokenizer = new StringTokenizer(reader.readLine());
            int N = Integer.parseInt(tokenizer.nextToken());    // 상근이의 CD 수
            int M = Integer.parseInt(tokenizer.nextToken());    // 선영이의 CD 수

            if (N == 0 && M == 0) break;

            int[] CD = new int[N];
            for (int i = 0; i < N; i++) {
                CD[i] = Integer.parseInt(reader.readLine());
            }

            int cnt = 0;
            for (int i = 0; i < M; i++) {
                if (Arrays.binarySearch(CD, Integer.parseInt(reader.readLine())) >= 0) cnt++;
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }

}
