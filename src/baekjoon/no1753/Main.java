package baekjoon.no1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1. 다익스트라 알고리즘(한 정점에서 다른 모든 정점으로의 최단거리 구하는 알고리즘)
 * 2. 시간 복잡도 -> PQ(힙) 이용 -> 대충 O(NlogN)...?
 * 3. 값 범위 -> 가중치가 10 이하이므로 int로 가능!
 */

public class Main {

    private static class Node implements Comparable<Node> {

        int to;     // 도착 정점
        int weight; // 시작 정점에서 이 정점까지 최단 경로 저장

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
        int V = Integer.parseInt(tokenizer.nextToken());    // 정점 개수
        int E = Integer.parseInt(tokenizer.nextToken());    // 간선 개수

        // 만들것 -> 인접리스트, 최단경로 저장 배열(값 비교 위해), 정점 확정 여부
        List<Node>[] adjList = new List[V + 1];
        for (int i = 0; i <= V; i++) {
            adjList[i] = new ArrayList<>();
        }

        int start = Integer.parseInt(reader.readLine());    // 시작 정점

        int[] weights = new int[V + 1];
        Arrays.fill(weights, Integer.MAX_VALUE);
        weights[start] = 0; // 자기 자신으로의 거리는 0이다.

        boolean[] isDefined = new boolean[V + 1];

        for (int i = 0; i < E; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(tokenizer.nextToken());     // 시작
            int to = Integer.parseInt(tokenizer.nextToken());       // 끝
            int weight = Integer.parseInt(tokenizer.nextToken());   // 가중치

            // 유향 그래프이다!
            adjList[from].add(new Node(to, weight));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (isDefined[curr.to]) continue;

            isDefined[curr.to] = true;

            // 현재 선택된 정점에서 갈 수 있는 모든 다른 노드를 살핀다.
            for (Node node : adjList[curr.to]) {
                // 만약, 지금 선택된 정점을 통해서 가는 경로가 더 최단인 경우
                if (!isDefined[node.to] && weights[node.to] > curr.weight + node.weight) {
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
