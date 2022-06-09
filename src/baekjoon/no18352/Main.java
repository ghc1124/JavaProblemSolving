package baekjoon.no18352;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static class Node implements Comparable<Node> {

        int num;    // 노드 번호
        int weight; // 해당 노드까지의 거리

        public Node(int num, int weight) {
            this.num = num;
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
        int N = Integer.parseInt(tokenizer.nextToken());    // 도시의 개수
        int M = Integer.parseInt(tokenizer.nextToken());    // 도로의 개수
        int K = Integer.parseInt(tokenizer.nextToken());    // 거리 정보
        int X = Integer.parseInt(tokenizer.nextToken());    // 출발 도시 번호

        List<Node>[] adjList = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(tokenizer.nextToken()); // 시작
            int to = Integer.parseInt(tokenizer.nextToken());   // 끝

            adjList[from].add(new Node(to, 1));  // 단방향 그래프
        }

        // 다익스트라 -> 방문 체크(확정 여부), 거리 배열 필요

        boolean[] isVisited = new boolean[N + 1];   // 방문 체크
        int[] weights = new int[N + 1]; // X로부터의 거리
        Arrays.fill(weights, Integer.MAX_VALUE);
        weights[X] = 0; // 출발지 처리. 자기 자신으로의 거리는 0

        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(X, 0)); // 출발 정점 번호

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (isVisited[curr.num]) continue;

            isVisited[curr.num] = true;
            weights[curr.num] = curr.weight;

            for (Node node : adjList[curr.num]) {
                if (!isVisited[node.num] && weights[node.num] > weights[curr.num] + node.weight) {
                    weights[node.num] = weights[curr.num] + node.weight;
                    queue.offer(new Node(node.num, weights[node.num]));
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (weights[i] == K) sb.append(i).append("\n");
        }

        System.out.println(sb.length() == 0 ? "-1" : sb);
    }

}
