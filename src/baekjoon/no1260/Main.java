package baekjoon.no1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken()); // 정점의 개수
        int M = Integer.parseInt(tokenizer.nextToken()); // 간선의 개수
        int V = Integer.parseInt(tokenizer.nextToken()); // 시작할 정점 번호

        // 양방향 그래프
        int[][] graph = new int[N + 1][N + 1]; // 1-base 인덱스
        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(tokenizer.nextToken()); // 시작
            int to = Integer.parseInt(tokenizer.nextToken()); // 끝

            graph[from][to] = graph[to][from] = 1;
        }

        dfs(graph, new boolean[N + 1], V, N);
        sb.append("\n");
        bfs(graph, new boolean[N + 1], V, N);
        System.out.println(sb);
    }

    // visited -> 1-base 인덱스 || current -> 현재 정점
    private static void dfs(int[][] graph, boolean[] visited, int current, int N) {
        visited[current] = true;
        sb.append(current).append(" ");

        for (int i = 1; i < N + 1; i++) {
            if (graph[current][i] == 1 && !visited[i]) {
                dfs(graph, visited, i, N);
            }
        }
    }

    private static void bfs(int[][] graph, boolean[] visited, int V, int N) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(V); // 시작점
        visited[V] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            sb.append(temp).append(" ");

            for (int i = 1; i < N + 1; i++) {
                if (graph[temp][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }

}
