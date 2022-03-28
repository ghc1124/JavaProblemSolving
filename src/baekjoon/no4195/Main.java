package baekjoon.no4195;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private static int[] parents, cnt;

    private static void makeSet(int n) {
        parents = new int[n];
        cnt = new int[n];

        for (int i = 0; i < n; i++) {
            parents[i] = i;
            cnt[i] = 1;
        }
    }

    private static boolean unionSet(int a, int b) {
        int parentA = findSet(a);
        int parentB = findSet(b);

        if (parentA == parentB) return false; // 이미 같은 집합

        parents[parentB] = parentA;
        cnt[parentA] += cnt[parentB];

        return true;
    }

    private static int findSet(int a) {
        if (a == parents[a]) return a;

        return parents[a] = findSet(parents[a]); // Path Compression
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine()); // 테스트케이스 개수

        while (T-- > 0) {
            int F = Integer.parseInt(reader.readLine()); // 친구 관계의 수

            Map<String, Integer> map = new HashMap<>();
            int index = 0;

            makeSet(F * 2);

            for (int i = 0; i < F; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                String a = tokenizer.nextToken();
                String b = tokenizer.nextToken();

                if (!map.containsKey(a)) map.put(a, index++);
                if (!map.containsKey(b)) map.put(b, index++);

                unionSet(map.get(a), map.get(b));

                sb.append(cnt[parents[map.get(a)]]).append("\n");
            }
        }

        System.out.println(sb);
    }

}
