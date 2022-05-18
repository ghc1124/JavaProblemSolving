package baekjoon.no6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder res = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = null;

        while (true) {
            tokenizer = new StringTokenizer(reader.readLine());

            int k = Integer.parseInt(tokenizer.nextToken());
            if (k == 0) break;

            int[] target = new int[k];
            for (int i = 0; i < k; i++) {
                target[i] = Integer.parseInt(tokenizer.nextToken());
            }

            combination(target, new StringBuilder(), 0, 0);
            res.append("\n");
        }

        System.out.println(res);
    }

    private static void combination(int[] target, StringBuilder sb, int cnt, int curr) {
        if (cnt == 6) {
            res.append(sb).append("\n");
            return;
        }

        for (int i = curr; i < target.length; i++) {
            int temp = sb.length();
            sb.append(target[i]).append(" ");
            combination(target, sb,cnt + 1, i + 1);
            sb.setLength(temp);
        }
    }

}
