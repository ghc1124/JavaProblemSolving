package baekjoon.no15654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int[] arr;
    private static int N, M;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        arr = new int[N];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(arr);

        permutation(new boolean[N], 0, new StringBuilder());

        System.out.println(sb);
    }

    private static void permutation(boolean[] isSelected, int cnt, StringBuilder cur) {
        if (cnt == M) {
            // 다 뽑음
            sb.append(cur).append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                int temp = cur.length();
                cur.append(arr[i]).append(" ");
                permutation(isSelected, cnt + 1, cur);
                cur.setLength(temp);
                isSelected[i] = false;
            }
        }
    }

}
