package baekjoon.no2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainBottomUp {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] stairs = new int[N + 1]; // 각 계단별 점수 저장용
        int[] scores = new int[N + 1]; // 계단별까지의 최댓값 저장용
        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(reader.readLine());
        }

        scores[1] = stairs[1]; // 1번 계단까지의 최댓값은 그냥 1번 계단의 수

        if (N >= 2) {
            scores[2] = stairs[1] + stairs[2];
        }

        for (int i = 3; i <= N; i++) {
            scores[i] = Math.max(scores[i - 2], scores[i - 3] + stairs[i - 1]) + stairs[i];
        }

        System.out.println(scores[N]);
    }

}
