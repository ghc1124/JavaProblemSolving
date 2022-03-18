package baekjoon.no11659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken()); // 수의 개수
        int M = Integer.parseInt(tokenizer.nextToken()); // 합을 구해야 하는 횟수

        tokenizer = new StringTokenizer(reader.readLine());
        int[] nums = new int[N + 1];

        // 누적 합
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(tokenizer.nextToken());
            nums[i + 1] = nums[i] + temp;
        }

        for (int x = 0; x < M; x++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int i = Integer.parseInt(tokenizer.nextToken());
            int j = Integer.parseInt(tokenizer.nextToken());

            int sum = nums[j] - nums[i - 1];
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }

}
