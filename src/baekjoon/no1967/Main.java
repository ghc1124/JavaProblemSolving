package baekjoon.no1967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static class Node {

        int num;    // 노드 번호
        int weight; // 가중치
        Node next;  // 다음 형제

        public Node(int num, int weight, Node next) {
            this.num = num;
            this.weight = weight;
            this.next = next;
        }

    }

    private static Node[] adjList;
    private static int result, index;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine()); // 노드의 개수
        adjList = new Node[N + 1]; // 1-base index

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(tokenizer.nextToken());
            int to = Integer.parseInt(tokenizer.nextToken());
            int weight = Integer.parseInt(tokenizer.nextToken());

            // 무향 그래프
            adjList[from] = new Node(to, weight, adjList[from]);
            adjList[to] = new Node(from, weight, adjList[to]);
        }

        int next = dfs(new boolean[N + 1], 1, 0);
        dfs(new boolean[N + 1], next, 0);

        System.out.println(result);
    }

    private static int dfs(boolean[] visited, int start, int sum) {
        visited[start] = true;

        for (Node node = adjList[start]; node != null; node = node.next) {
            if (!visited[node.num]) {
                dfs(visited, node.num, sum + node.weight);
            }
        }

        if (result < sum) {
            result = sum;
            index = start;
        }

        return index;
    }

}
