package baekjoon.no2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static int[] stairs;
    private static int[] scores; // 메모이제이션 용

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        stairs = new int[N + 1]; // 각 계단별 점수 저장용
        scores = new int[N + 1]; // 계단별까지의 최댓값 저장용
        Arrays.fill(scores, -1);
        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(reader.readLine());
        }

        scores[0] = stairs[0]; // dummy 값
        scores[1] = stairs[1]; // 1번 계단까지의 최댓값은 그냥 1번 계단의 수

        if (N >= 2) scores[2] = stairs[1] + stairs[2]; // 들어오는 수는 자연수로, 1이 들어올 때를 대비하여 처리. 2번 계단까지의 최댓값

        System.out.println(dynamicPrograming(N));
    }

    private static int dynamicPrograming(int stair) {
        if (scores[stair] == -1) { // 아직 값이 등록이 안 된 경우
            scores[stair] = Math.max(dynamicPrograming(stair - 2), dynamicPrograming(stair - 3) + stairs[stair - 1]) + stairs[stair];
        }

        return scores[stair];
    }

}
