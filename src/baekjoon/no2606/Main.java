package baekjoon.no2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static class Edge {

        int to;
        Edge next;

        public Edge(int to, Edge next) {
            this.to = to;
            this.next = next;
        }

    }

    private static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine()); // 컴퓨터의 수
        int M = Integer.parseInt(reader.readLine()); // 연결된 쌍의 수

        Edge[] adjList = new Edge[N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(tokenizer.nextToken());
            int to = Integer.parseInt(tokenizer.nextToken());
            adjList[from] = new Edge(to, adjList[from]);
            adjList[to] = new Edge(from, adjList[to]);
        }

        // System.out.println(bfs(adjList));

        dfs(adjList, new boolean[N + 1], 1);

        System.out.println(cnt - 1);
    }

    private static int bfs(Edge[] adjList) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);

        int result = 0;

        boolean[] visited = new boolean[adjList.length];
        visited[1] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for (Edge edge = adjList[temp]; edge != null; edge = edge.next) {
                if (!visited[edge.to]) {
                    visited[edge.to] = true;
                    result++;
                    queue.offer(edge.to);
                }
            }
        }

        return result;
    }

    private static void dfs(Edge[] adjList, boolean[] visited, int curr) {
        visited[curr] = true;
        cnt++;

        for (Edge edge = adjList[curr]; edge != null; edge = edge.next) {
            if (!visited[edge.to]) {
                dfs(adjList, visited, edge.to);
            }
        }
    }

}
