package baekjoon.no4485;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static class Node implements Comparable<Node> {

        int weight;
        int row;
        int col;

        public Node(int weight, int row, int col) {
            this.weight = weight;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, };

        int idx = 0;
        int N = 0;

        while ((N = Integer.parseInt(reader.readLine())) != 0) {
            int[][] matrix = new int[N][N];
            int[][] costs = new int[N][N];
            boolean[][] visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                    costs[i][j] = Integer.MAX_VALUE;
                }
            }

            costs[0][0] = matrix[0][0];

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(matrix[0][0], 0, 0));

            while (!pq.isEmpty()) {
                Node node = pq.poll();

                if (visited[node.row][node.col]) continue;
                if (node.row == N - 1 && node.col == N - 1) break;

                visited[node.row][node.col] = true;

                for (int i = 0; i < 4; i++) {
                    int dy = node.row + directions[i][0];
                    int dx = node.col + directions[i][1];

                    if (dy >= 0 && dy < N && dx >= 0 && dx < N) {
                        if (costs[dy][dx] > costs[node.row][node.col] + matrix[dy][dx]) {
                            costs[dy][dx] = costs[node.row][node.col] + matrix[dy][dx];
                            pq.offer(new Node(costs[dy][dx], dy, dx));
                        }
                    }
                }
            }

            sb.append("Problem ").append(++idx).append(": ");
            sb.append(costs[N - 1][N - 1]).append("\n");
        }

        System.out.println(sb);
    }

}
