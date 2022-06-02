package baekjoon.no1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());    // 정수의 개수
        int S = Integer.parseInt(tokenizer.nextToken());    // 합

        int[] num = new int[N];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(tokenizer.nextToken());
        }

        powerSet(num, N, S, 0, 0);

        System.out.println(S == 0 ? res - 1 : res);
    }

    private static void powerSet(int[] num, int N, int S, int index, int curr) {
        if (index == N) {
            if (curr == S) res++;
            return;
        }

        powerSet(num, N, S, index + 1, curr + num[index]);
        powerSet(num, N, S, index + 1, curr);
    }

}