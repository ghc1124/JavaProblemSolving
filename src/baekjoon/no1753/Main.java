package baekjoon.no1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static class Node implements Comparable<Node> {

        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int V = Integer.parseInt(tokenizer.nextToken());    // 정점의 개수
        int E = Integer.parseInt(tokenizer.nextToken());    // 간선의 개수

        List<Node>[] adjList = new List[V + 1];
        for (int i = 0; i <= V; i++) {
            adjList[i] = new ArrayList<>();
        }

        int K = Integer.parseInt(reader.readLine());    // 시작 정점

        for (int i = 0; i < E; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(tokenizer.nextToken());
            int to = Integer.parseInt(tokenizer.nextToken());
            int weight = Integer.parseInt(tokenizer.nextToken());
            adjList[from].add(new Node(to, weight));
        }

        int[] weights = new int[V + 1]; // 각각 정점으로의 가중치를 담기 위한 배열
        Arrays.fill(weights, Integer.MAX_VALUE);
        weights[K] = 0; // 시작 정점(자기 자신으로의 가중치는 0)
        boolean[] isSelected = new boolean[V + 1];  // 각각 정점이 확정되었는지 판별하기 위한 배열

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(K, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (isSelected[curr.to]) continue;

            isSelected[curr.to] = true;

            for (Node node : adjList[curr.to]) {
                if (!isSelected[node.to] && weights[node.to] > curr.weight + node.weight) {
                    weights[node.to] = curr.weight + node.weight;
                    pq.offer(new Node(node.to, weights[node.to]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            sb.append(weights[i] == Integer.MAX_VALUE ? "INF" : weights[i]).append("\n");
        }

        System.out.println(sb);
    }

}