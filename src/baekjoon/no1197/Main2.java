package baekjoon.no1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Prim Algorithm
 */

public class Main2 {

    private static class Node implements Comparable<Node> {

        int no; // 노드 번호
        int weight; // 가중치
        Node next; // 다음 노드

        public Node(int no, int weight, Node next) {
            this.no = no;
            this.weight = weight;
            this.next = next;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int V = Integer.parseInt(tokenizer.nextToken()); // 정점의 개수
        int E = Integer.parseInt(tokenizer.nextToken()); // 간선의 개수

        Node[] adjList = new Node[V + 1]; // 1-base index
        for (int i = 0; i < E; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(tokenizer.nextToken());
            int to = Integer.parseInt(tokenizer.nextToken());
            int weight = Integer.parseInt(tokenizer.nextToken());

            // 양방향 그래프
            adjList[from] = new Node(to, weight, adjList[from]);
            adjList[to] = new Node(from, weight, adjList[to]);
        }

        boolean[] visited = new boolean[V + 1]; // 정점 선택 여부 기록
        int[] distance = new int[V + 1]; // 각 정점으로 최소 거리를 기록
        Arrays.fill(distance, Integer.MAX_VALUE);

        int start = 1;

        // 시작점은 1번 정점으로 가정
        distance[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, distance[start], null));

        int result = 0, cnt = 0;

        // 모든 정점에 대해 반복
        while (!pq.isEmpty()) {
            Node minNode = pq.poll();

            if (visited[minNode.no]) continue; // 이미 탐색한 노드의 경우 패스

            visited[minNode.no] = true; // 선택 처리
            result += minNode.weight; // 가중치 업데이트

            for (Node node = adjList[minNode.no]; node != null; node = node.next) {
                if (!visited[node.no] && distance[node.no] > node.weight) {
                    distance[node.no] = node.weight;
                    pq.offer(new Node(node.no, distance[node.no], null));
                }
            }
        }

        System.out.println(result);
    }

}
