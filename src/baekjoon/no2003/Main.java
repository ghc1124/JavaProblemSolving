package baekjoon.no2003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());    // 수의 개수
        int M = Integer.parseInt(tokenizer.nextToken());    // 목표 수

        tokenizer = new StringTokenizer(reader.readLine());
        int[] num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int left = 0, right = 0;    // left가 증가 -> 수 감소, right가 증가 -> 수 증가
        int sum = num[right];
        int cnt = 0;

        while (true) {
            if (sum < M) {
                ++right;
                if (right >= N) break;
                sum += num[right];
            }
            else if (sum > M) sum -= num[left++];
            else {
                cnt++;
                sum -= num[left++];
            }
        }

        System.out.println(cnt);
    }

}
