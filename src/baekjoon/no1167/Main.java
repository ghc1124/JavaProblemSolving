package baekjoon.no1167;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 인접리스트를 만들기 위한 클래스
    private static class Node {

        int value;
        int weight;
        Node next;

        public Node(int value, int weight, Node next) {
            this.value = value;
            this.weight = weight;
            this.next = next;
        }

    }

    private static Node[] adjList;
    private static int tempLength, tempIndex;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(reader.readLine()); // 정점의 개수

        adjList = new Node[V + 1]; // 1-base index
        int[] cnt = new int[V + 1];
        boolean[] target = new boolean[V + 1];
        for (int i = 0; i < V; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int value = Integer.parseInt(tokenizer.nextToken()); // 정점 번호
            int temp = 0;
            while ((temp = Integer.parseInt(tokenizer.nextToken())) != -1) { // -1이 아닐 때까지 진행
                adjList[value] = new Node(temp, Integer.parseInt(tokenizer.nextToken()), adjList[value]); // 정점 번호, 가중치, 다음 노드 주소
                cnt[value]++;
            }
        }

        dfs(1, new boolean[V + 1], 0);

        System.out.println(dfs(tempIndex, new boolean[V + 1], 0));
    }

    private static int dfs(int target, boolean[] visited, int length) {
        visited[target] = true;

        for (Node node = adjList[target]; node != null; node = node.next) {
            if (!visited[node.value]) { // 아직 방문하지 않은 노드의 경우
                dfs(node.value, visited, length + node.weight);
            }
        }

        // 갈 수 있는 끝까지 탐색한 경우
        if (tempLength < length) {
            tempLength = length;
            tempIndex = target;
        }

        return tempLength;
    }

}
