package baekjoon.no2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());    // 카드의 개수
        int M = Integer.parseInt(tokenizer.nextToken());    // 목표 수

        int[] cards = new int[N];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(tokenizer.nextToken());
        }

        combination(cards, 0, 0, 0, M);

        System.out.println(res);
    }

    private static void combination(int[] cards, int index, int cnt, int curr, int M) {
        if (curr > M) return;

        if (cnt == 3) {
            res = Math.max(res, curr);
            return;
        }

        for (int i = index; i < cards.length; i++) {
            combination(cards, i + 1, cnt + 1, curr + cards[i], M);
        }
    }

}
