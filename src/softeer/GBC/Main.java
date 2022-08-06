package softeer.GBC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static class Elevator {

        int distance;
        int velocity;

        public Elevator(int distance, int velocity) {
            this.distance = distance;
            this.velocity = velocity;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());    // 구간의 수
        int M = Integer.parseInt(tokenizer.nextToken());    // 검사 구간의 수

        Elevator[] elevators = new Elevator[N]; // 원래 정보
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int distance = Integer.parseInt(tokenizer.nextToken());
            int velocity = Integer.parseInt(tokenizer.nextToken());

            if (i > 0) distance += elevators[i - 1].distance;
            elevators[i] = new Elevator(distance, velocity);
        }

        int index = 0;  // 확인해야할 시작 인덱스
        int lastDist = 0;   // 직전의 거리
        int gap = 0;    // 거리 차

        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int distance = Integer.parseInt(tokenizer.nextToken());
            int velocity = Integer.parseInt(tokenizer.nextToken());

            if (i > 0) distance += lastDist;

            for (int j = index; j < N; j++) {
                if (elevators[j].distance > distance) {
                    index = j;
                    gap = Math.max(gap, velocity - elevators[j].velocity);
                    break;
                } else if (elevators[j].distance == distance) {
                    index = j + 1;
                    gap = Math.max(gap, velocity - elevators[j].velocity);
                    break;
                }

                gap = Math.max(gap, velocity - elevators[j].velocity);
            }

            lastDist = distance;
        }

        System.out.println(gap);
    }

}
