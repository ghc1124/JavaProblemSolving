package baekjoon.no19592;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());    // 테스트케이스 개수
        for (int t = 0; t < T; t++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int N = Integer.parseInt(tokenizer.nextToken());    // 참가번호
            int X = Integer.parseInt(tokenizer.nextToken());    // 트랙 길이
            int Y = Integer.parseInt(tokenizer.nextToken());    // 부스터 속도 한계치

            int[] V = new int[N];
            tokenizer = new StringTokenizer(reader.readLine());
            int maxSpeed = 0;
            for (int i = 0; i < N; i++) {
                V[i] = Integer.parseInt(tokenizer.nextToken());
                maxSpeed = Math.max(maxSpeed, V[i]);
            }

            if (maxSpeed == V[N - 1]) {
                // 부스터 안써도 이기는 상황
            } else {
                int fastestTime = X / maxSpeed;

                int min = 0;
                int max = Y;

                while (min < max) {
                    int mid = (min + max) / 2;

                    int time = 1 + (X - max) / V[N - 1];

                    if (time < fastestTime) max = mid;
                    else min = mid + 1;
                }

                System.out.println(min);
            }
        }
    }

}
