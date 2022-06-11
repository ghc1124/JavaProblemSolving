package baekjoon.no10815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int[] cards;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());    // 숫자 카드의 개수
        cards = new int[N];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(cards);

        int M = Integer.parseInt(reader.readLine());    // 찾아야할 카드의 개수
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < M; i++) {
            sb.append(binarySearch(0, N - 1, Integer.parseInt(tokenizer.nextToken())) ? 1 : 0).append(" ");
        }

        System.out.println(sb);
    }

    private static boolean binarySearch(int start, int end, int target) {
        if (start == end) {
            return cards[start] == target;
        }

        int mid = (start + end) / 2;

        if (cards[mid] < target) {
            return binarySearch(mid + 1, end, target);
        } else {
            return binarySearch(start, mid, target);
        }
    }

}
