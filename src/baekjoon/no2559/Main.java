package baekjoon.no2559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());    // 전체 날짜 수
        int K = Integer.parseInt(tokenizer.nextToken());    // 연속적인 날짜의 수

        tokenizer = new StringTokenizer(reader.readLine());
        int[] temp = new int[N];
        for (int i = 0; i < N; i++) {
            temp[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int sum = 0;    // 합을 저장하기 위한 변수 -> 일단 처음 K개의 합으로 초기화
        for (int i = 0; i < K; i++) {
            sum += temp[i];
        }

        int ans = sum;    // 온도를 저장하기 위한 변수

        for (int i = K; i < N; i++) {
            sum -= temp[i - K];
            sum += temp[i];
            ans = Math.max(ans, sum);
        }

        System.out.println(ans);
    }

}
