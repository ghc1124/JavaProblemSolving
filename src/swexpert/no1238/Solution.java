package swexpert.no1238;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    private static class Node {

        int vertex; // 정점 번호
        Node next; // 다음 정점

        public Node(int vertex, Node next) {
            this.vertex = vertex;
            this.next = next;
        }

    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int problemNum = 1;

        for (int i = 0; i < 10; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int E = Integer.parseInt(tokenizer.nextToken()); // Edge 개수
            int S = Integer.parseInt(tokenizer.nextToken()); // 시작점

            // 정점은 최대 100개
            Node[] adjList = new Node[101];
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < E; j += 2) {
                int from = Integer.parseInt(tokenizer.nextToken());
                int to = Integer.parseInt(tokenizer.nextToken());
                adjList[from] = new Node(to, adjList[from]);
            }

            sb.append("#").append(problemNum++).append(" ");
            sb.append(bfs(adjList, S)).append("\n");
        }

        System.out.println(sb);
    }

    private static int bfs(Node[] adjList, int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[101];

        queue.offer(start);
        visited[start] = true;

        int max = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            max = 0;
            // 레벨별 구분 동작
            while (size-- > 0) {
                int temp = queue.poll(); // 현재 정점

                max = Math.max(max, temp);

                for (Node node = adjList[temp]; node != null; node = node.next) {
                    if (!visited[node.vertex]) {
                        visited[node.vertex] = true;
                        queue.offer(node.vertex);
                    }
                }
            }
        }

        return max;
    }

}
