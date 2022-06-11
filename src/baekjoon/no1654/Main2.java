package baekjoon.no1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int K = Integer.parseInt(tokenizer.nextToken());    // 이미 가지고 있는 랜선의 개수
        int N = Integer.parseInt(tokenizer.nextToken());    // 필요한 랜선의 수

        int[] lanCable = new int[K];
        long min = 1;
        long max = 0;
        for (int i = 0; i < K; i++) {
            lanCable[i] = Integer.parseInt(reader.readLine());
            max = Math.max(max, lanCable[i]);   // 최댓값 찾기
        }

        while (min <= max) {
            long mid = (min + max) / 2;

            int cnt = 0;
            for (int i = 0; i < K; i++) {
                cnt += lanCable[i] / mid;
            }

            if (cnt < N) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        System.out.println((min + max) / 2);
    }

}
