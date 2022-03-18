package baekjoon.no1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int K = Integer.parseInt(tokenizer.nextToken()); // 가지고 있는 랜선의 개수
        int N = Integer.parseInt(tokenizer.nextToken()); // 필요한 랜선의 개수

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < K; i++) {
            pq.offer(Integer.parseInt(reader.readLine()));
        }

        long maxValue = 0;
        long minValue = 0;
        long midValue = 0;

        if (!pq.isEmpty()) maxValue = pq.peek() + 1L;

        System.out.println(maxValue);

        while (minValue < maxValue) { // 상한 찾기
            midValue = (minValue + maxValue) / 2; // 중간값

            long temp = 0;
            for (int n : pq) {
                temp += n / midValue;
            }

            if (temp < N) { // 구해야 하는 갯수보다 적은 경우 -> 더 잘게 잘라야된다. 즉, 자르는 길이를 줄여야된다.
                maxValue = midValue;
            } else { // 구해야 하는 갯수보다 많거나 같은 경우(즉 조건을 충족한 경우), 최댓값을 찾기 위해 계속 진행한다.
                minValue = midValue + 1;
            }
        }

        System.out.println(minValue - 1);
    }

}
