package baekjoon.no1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 이진탐색이다.
 * 2. 시간복잡도 -> O(logN) 가능
 * 3. 2^31 -> int 가능
 */

public class Main {

    private static int[] num;
    private static boolean ans;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        num = new int[N];

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(num);

        int M = Integer.parseInt(reader.readLine());
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < M; i++) {
            ans = false;
            binarySearch(0, N - 1, Integer.parseInt(tokenizer.nextToken()));
            sb.append(ans ? 1 : 0).append("\n");
        }

        System.out.println(sb);
    }

    private static void binarySearch(int start, int end, int target) {
        if (start == end) {
            ans = num[start] == target;
            return;
        }

        int mid = (start + end) / 2;

        if (num[mid] < target) binarySearch(mid + 1, end, target);
        else binarySearch(start, mid, target);
    }

}
