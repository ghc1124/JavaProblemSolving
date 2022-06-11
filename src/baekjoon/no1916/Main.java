package baekjoon.no1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static class Node {

        int nodeNum;
        int weight;

        public Node(int nodeNum, int weight) {
            this.nodeNum = nodeNum;
            this.weight = weight;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());    // 도시의 개수
        int M = Integer.parseInt(reader.readLine());    // 버스의 개수

        List<Node>[] adjList = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        StringTokenizer tokenizer = null;

        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(tokenizer.nextToken()); // 출발 도시
            int to = Integer.parseInt(tokenizer.nextToken());   // 도착 도시
            int weight = Integer.parseInt(tokenizer.nextToken());   // 비용

            adjList[from].add(new Node(to, weight));
        }

        tokenizer = new StringTokenizer(reader.readLine());
        int start = Integer.parseInt(tokenizer.nextToken());    // 출발 도시
        int end = Integer.parseInt(tokenizer.nextToken());      // 도착 도시

        boolean[] isVisited = new boolean[N + 1];
        int[] weights = new int[N + 1];
        Arrays.fill(weights, Integer.MAX_VALUE);
        weights[start] = 0;

        Queue<Node> pq = new PriorityQueue<>((Comparator.comparingInt(o -> o.weight)));
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (isVisited[curr.nodeNum]) continue;

            isVisited[curr.nodeNum] = true;         // 방문 처리
            weights[curr.nodeNum] = curr.weight;    // 최솟값 업데이트

            if (curr.nodeNum == end) break;

            for (Node node : adjList[curr.nodeNum]) {
                if (!isVisited[node.nodeNum] && weights[node.nodeNum] > weights[curr.nodeNum] + node.weight) {
                    weights[node.nodeNum] = weights[curr.nodeNum] + node.weight;
                    pq.offer(new Node(node.nodeNum, weights[node.nodeNum]));
                }
            }
        }

        System.out.println(weights[end]);
    }

}
