package baekjoon.no20040;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] parents;

    private static void makeSet(int n) {
        parents = new int[n];

        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }

    private static boolean unionSet(int a, int b) {
        int parentA = findSet(a);
        int parentB = findSet(b);

        if (parentA == parentB) return false; // 이미 같은 집합

        parents[parentB] = parentA; // Union!

        return true;
    }

    private static int findSet(int a) {
        if (a == parents[a]) return a;

        return parents[a] = findSet(parents[a]); // Path Compression
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        makeSet(N);

        int result = 0;

        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());

            if (!unionSet(a, b)) {
                result = i + 1;
                break;
            }
        }

        System.out.println(result);
    }

}
