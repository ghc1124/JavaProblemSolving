package jungol.no1681;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static class Node {

        int no;
        int weight;
        Node next;

        public Node(int no, int weight, Node next) {
            this.no = no;
            this.weight = weight;
            this.next = next;
        }

    }

    private static int answer = Integer.MAX_VALUE;
    private static int[][] adjMatrix;
    private static Node[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine()); // 정점 개수

        adjMatrix = new int[N][N];
        adjList = new Node[N]; // 인접리스트
        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(tokenizer.nextToken());

                adjMatrix[i][j] = temp;

                if (temp != 0) {
                    adjList[i] = new Node(j, temp, adjList[i]);
                }
            }
        }

        dfs(new boolean[N], 0, 0, 0, N);

        System.out.println(answer);
    }

    public static void dfs(boolean[] visited, int sum, int no, int cnt, int N) {
        visited[no] = true;

        if (sum > answer) return;

        if (cnt == N - 1) {
            if (adjMatrix[no][0] == 0) return;

            sum += adjMatrix[no][0];
            answer = Math.min(answer, sum);
            return;
        }

        // 인접 리스트에서 반복
        for (Node node = adjList[no]; node != null; node = node.next) {
            if (!visited[node.no]) {
                dfs(visited, sum + node.weight, node.no, cnt + 1, N);
                visited[node.no] = false;
            }
        }
    }

}
