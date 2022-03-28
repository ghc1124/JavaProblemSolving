package baekjoon.no1774;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
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

        if (parentA == parentB) return false;

        parents[parentB] = parentA;

        return true;
    }

    private static int findSet(int a) {
        if (a == parents[a]) return a;

        return parents[a] = findSet(parents[a]); // Path Compression
    }

    private static class Edge implements Comparable<Edge> {

        int from;
        int to;
        double weight;

        public Edge(int from, int to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.weight, o.weight);
        }
    }

    private static PriorityQueue<Edge> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(tokenizer.nextToken()); // 우주신들의 개수
        int M = Integer.parseInt(tokenizer.nextToken()); // 신들과의 통로의 개수

        int[][] matrix = new int[N][2];

        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int y = Integer.parseInt(tokenizer.nextToken());
            int x = Integer.parseInt(tokenizer.nextToken());
            matrix[i][0] = y;
            matrix[i][1] = x;
        }

        makeSet(N);
        double result = 0.;

        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken()) - 1;
            int b = Integer.parseInt(tokenizer.nextToken()) - 1;

            unionSet(a, b);
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                int[] a = matrix[i];
                int[] b = matrix[j];

                double distance = Math.sqrt(Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));

                pq.offer(new Edge(i, j, distance));
            }
        }

        int cnt = M;

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            if (unionSet(curr.from, curr.to)) {
                result += curr.weight;
                if (++cnt == N - 1) break;
            }
        }

        System.out.printf("%.2f", result);
    }

}
