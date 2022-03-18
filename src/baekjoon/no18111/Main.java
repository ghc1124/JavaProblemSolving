package baekjoon.no18111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken()); // 세로
        int M = Integer.parseInt(tokenizer.nextToken()); // 가로
        int B = Integer.parseInt(tokenizer.nextToken()); // 인벤토리 보유량

        // 리스트 채우기
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < M; j++) {
                int temp = Integer.parseInt(tokenizer.nextToken());
                pq.offer(temp);
            }
        }

        int finalTime = Integer.MAX_VALUE, finalHeight = 0;

        Outer: for (int x = 256; x >= 0; x--) {
            int copyB = B;
            int time = 0; // 걸리는 시간
            int height = x; // 높이
            for (int n : pq) {
                if (n > height) {
                    time += (n - height) * 2; // 깎기
                    copyB += n - height;
                } else if (n < height) {
                    if (copyB - (height - n) >= 0) { // 인벤토리에서 꺼낼 수 있는 경우
                        time += height - n;
                        copyB -= height - n;
                    } else { // 인벤토리에서 꺼낼 수 없는 경우
                        continue Outer;
                    }
                }

                if (time > finalTime) continue Outer;
            }

            if (finalTime > time) {
                finalTime = time;
                finalHeight = height;
            }
        }

        System.out.println(finalTime + " " + finalHeight);
    }

}
