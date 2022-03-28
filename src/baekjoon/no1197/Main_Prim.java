package baekjoon.no1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Prim Algorithm
 * 인접 리스트가 필요
 * 현재 노드에서 갈 수 있는 가장 가까운 정점 선택(가중치가 작은)
 * 정점이 선택되면 가중치 업데이트
 * 선택된 노드에서 닿을 수 있는 모든 정점들의 가중치를 업데이트(이미 정해진 정점도 새로운 노드를 경유해서 가는게 더 짧을 경우 업데이트)
 * 모든 정점이 선택될 때까지 반복
 */

public class Main_Prim {

    private static class Node implements Comparable<Node> {

        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int V = Integer.parseInt(tokenizer.nextToken()); // 정점 개수
        int E = Integer.parseInt(tokenizer.nextToken()); // 간선 개수

        boolean[] isVisited = new boolean[V + 1]; // 정점 선택 여부
        int[] weights = new int[V + 1]; // 각 정점에 도달하기 위한 최소 가중치

        Arrays.fill(weights, Integer.MAX_VALUE);

        int root = 1;
        weights[1] = 0; // 루트 설정

        List<Node>[] adjList = new List[V + 1]; // 1-based index

        for (int i = 0; i <= V; i++) {
            adjList[i] = new ArrayList<>();
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(root, weights[root])); // 루트 추가

        for (int i = 0; i < E; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(tokenizer.nextToken());
            int to = Integer.parseInt(tokenizer.nextToken());
            int weight = Integer.parseInt(tokenizer.nextToken());

            // 양방향 리스트 -> 각 정점에서 최소의 간선을 택한다.
            adjList[from].add(new Node(to, weight));
            adjList[to].add(new Node(from, weight));
        }

        int result = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (isVisited[curr.vertex]) continue;

            isVisited[curr.vertex] = true;
            result += curr.weight;

            for (Node node : adjList[curr.vertex]) {
                if (!isVisited[node.vertex] && weights[node.vertex] > node.weight) {
                    weights[node.vertex] = node.weight;
                    pq.offer(new Node(node.vertex, node.weight));
                }
            }
        }

        System.out.println(result);
    }

}
