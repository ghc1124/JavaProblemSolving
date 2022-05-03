package baekjoon.no15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        permutation(0, new StringBuilder(), new boolean[N + 1]);

        System.out.println(sb);
    }

    private static void permutation(int cnt, StringBuilder curr, boolean[] selected) {
        if (cnt == M) {
            sb.append(curr).append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!selected[i]) {
                selected[i] = true;
                int temp = curr.length();
                curr.append(i).append(" ");
                permutation(cnt + 1, curr, selected);
                selected[i] = false;
                curr.setLength(temp);
            }
        }
    }

}
