package baekjoon.no9372;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine()); // 테스트케이스 개수

        while (T-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int N = Integer.parseInt(tokenizer.nextToken()); // 국가의 수
            int M = Integer.parseInt(tokenizer.nextToken()); // 비행기의 종류


            for (int i = 0; i < M; i++) {
                reader.readLine();
            }

            sb.append(N - 1).append("\n");
        }

        System.out.println(sb);
    }

}
