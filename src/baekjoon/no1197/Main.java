package baekjoon.no1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Kruskal Algorithm
 */

public class Main {

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

    private static void makeSet(int V) {
        parents = new int[V + 1]; // 1-base index
        for (int i = 1; i <= V; i++) {
            parents[i] = i;
        }
    }

    private static int findSet(int n) {
        if (n == parents[n]) return n; // 자기가 곧 대표자인 경우

        return parents[n] = findSet(parents[n]); // 대표자 업데이트
    }

    private static boolean unionSet(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if (aRoot == bRoot) return false;

        parents[bRoot] = aRoot;
        return true;
    }

    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int V = Integer.parseInt(tokenizer.nextToken()); // 정점의 개수
        int E = Integer.parseInt(tokenizer.nextToken()); // 간선의 개수

        makeSet(V);

        List<Edge> edgeList = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(tokenizer.nextToken());
            int to = Integer.parseInt(tokenizer.nextToken());
            int weight = Integer.parseInt(tokenizer.nextToken());

            edgeList.add(new Edge(from, to, weight));
        }

        Collections.sort(edgeList); // 정렬

        int result = 0, cnt = 0;

        // 간선의 수만큼 반복
        for (Edge edge : edgeList) {
            // 합침에 성공한 경우(원래 서로 다른 트리인 경우)
            if (unionSet(edge.from, edge.to)) {
                result += edge.weight;
                if (++cnt == V - 1) break; // 이미 MST가 완성된 경우 더 이상의 간선은 안봐도 됨
            }
        }

        System.out.println(result);
    }

}
