package baekjoon.no11945;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());    // 행 수
        int M = Integer.parseInt(tokenizer.nextToken());    // 열 수

        for (int i = 0; i < N; i++) {
            sb.append(new StringBuilder(reader.readLine()).reverse()).append("\n");
        }

        System.out.println(sb);
    }

}
