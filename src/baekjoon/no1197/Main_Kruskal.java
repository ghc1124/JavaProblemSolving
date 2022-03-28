package baekjoon.no1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Kruskal Algorithm
 * Union-Find 알고리즘 적용(사이클이 없는 트리를 만들기 위해)
 * Edge 배열을 만들고 그리디한 방법으로 가장 가중치가 작은 간선 선택
 * 정점 개수 - 1개의 간선이 선택되면 마무리
 */

public class Main_Kruskal {

    private static class Edge implements Comparable<Edge> {

        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    private static int[] parents;

    private static void makeSet(int n) {
        parents = new int[n + 1]; // 1-based index

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
        if (a == parents[a]) return a;

        return parents[a] = findSet(parents[a]); // Path Compression
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int V = Integer.parseInt(tokenizer.nextToken()); // 정점 개수
        int E = Integer.parseInt(tokenizer.nextToken()); // 간선 개수

        makeSet(V);

        PriorityQueue<Edge> edgeList = new PriorityQueue<>();

        for (int i = 0; i < E; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(tokenizer.nextToken());
            int to = Integer.parseInt(tokenizer.nextToken());
            int weight = Integer.parseInt(tokenizer.nextToken());

            edgeList.offer(new Edge(from, to, weight));
        }

        int result = 0;
        int cnt = 0;

        while (!edgeList.isEmpty()) {
            Edge current = edgeList.poll();

            if (unionSet(current.from, current.to)) {
                result += current.weight;
                if (++cnt == V - 1) break;
            }
        }

        System.out.println(result);
    }

}
