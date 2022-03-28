package baekjoon.no4386;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * kruskal algorithm
 */

public class Main {

    private static int[] parents;

    private static float[][] point;

    private static PriorityQueue<Edge> pq = new PriorityQueue<>();

    private static class Edge implements Comparable<Edge> {

        int from;
        int to;
        float weight;

        public Edge(int from, int to, float weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return (int) (this.weight - o.weight);
        }
    }

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

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine()); // 별의 개수
        point = new float[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            float a = Float.parseFloat(tokenizer.nextToken());
            float b = Float.parseFloat(tokenizer.nextToken());
            point[i][0] = a;
            point[i][1] = b;
        }

        combination(N, 0, 0, new int[2]);

        makeSet(N);

        int cnt = 0;
        float result = 0.f;

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (unionSet(edge.from, edge.to)) {
                result += edge.weight;
                if (++cnt == N - 1) break;
            }
        }

        System.out.printf("%.2f", result);
    }

    private static void combination(int size, int curr, int cnt, int[] target) {
        if (cnt == 2) {
            // 2개를 뽑았을 때
            pq.offer(new Edge(target[0], target[1], calcDist(target[0], target[1])));
            return;
        }

        for (int i = curr; i < size; i++) {
            target[cnt] = i;
            combination(size, i + 1, cnt + 1, target);
        }
    }

    private static float calcDist(int a, int b) {
        float distX = point[a][1] - point[b][1];
        float distY = point[a][0] - point[b][0];

        return (float) Math.sqrt(Math.pow(distX, 2) + Math.pow(distY, 2));
    }

}
