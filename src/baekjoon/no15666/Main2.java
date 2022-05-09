package baekjoon.no15666;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {

    private static int N, M;
    private static int[] num;
    private static Set<String> ans = new LinkedHashSet<>();
    private static StringBuilder res = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        num = new int[N];

        tokenizer = new StringTokenizer(reader.readLine());

        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(num);

        combination(0, 0, new StringBuilder());

        Iterator<String> iterator = ans.iterator();
        while (iterator.hasNext()) {
            res.append(iterator.next()).append("\n");
        }

        System.out.println(res);
    }

    private static void combination(int start, int cnt, StringBuilder sb) {
        if (cnt == M) {
            ans.add(sb.toString());
            return;
        }

        for (int i = start; i < N; i++) {
            int temp = sb.length();
            sb.append(num[i]).append(" ");
            combination(i, cnt + 1, sb);
            sb.setLength(temp);
        }
    }

}
