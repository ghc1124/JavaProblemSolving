package baekjoon.no1976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] parents;

    private static void makeSet(int n) {
        parents = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parents[i] = i;
        }
    }

    private static boolean unionSet(int a, int b) {
        int parentA = findSet(a);
        int parentB = findSet(b);

        if (parentA == parentB) return false;

        parents[parentB] = parentA;

        return true;
    }

    private static int findSet(int a) {
        if (parents[a] == a) return a;

        return parents[a] = findSet(parents[a]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine()); // 도시의 수
        int M = Integer.parseInt(reader.readLine()); // 여행 계획에 속한 도시들의 수

        makeSet(N);

        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(tokenizer.nextToken()) == 1) unionSet(i + 1, j + 1);
            }
        }

        String[] temp = reader.readLine().split(" ");
        boolean flag = true;
        for (int i = 0; i < temp.length - 1; i++) {
            if (findSet(Integer.parseInt(temp[i])) != findSet(Integer.parseInt(temp[i + 1]))) {
                flag = false;
                break;
            }
        }

        System.out.println(flag ? "YES" : "NO");
    }

}
