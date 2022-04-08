package swexpert.no1249;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution {

    private static class Node implements Comparable<Node> {

        int y;
        int x;
        int cost;

        public Node(int y, int x, int cost) {
            this.y = y;
            this.x = x;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    private static int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());        // 테스트케이스 개수

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(reader.readLine());    // 지도 크기
            int[][] matrix = new int[N][N];
            int[][] costs = new int[N][N];
            boolean[][] visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                char[] temp = reader.readLine().toCharArray();
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = temp[j] - '0';
                    costs[i][j] = Integer.MAX_VALUE;
                }
            }

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(0, 0, 0));
            costs[0][0] = 0;

            while (!pq.isEmpty()) {
                Node node = pq.poll();
                int y = node.y;
                int x = node.x;
                int cost = node.cost;

                if (visited[y][x]) continue;
                if (y == N - 1 && x == N - 1) {
                    sb.append("#").append(t + 1).append(" ");
                    sb.append(costs[N - 1][N - 1]).append("\n");
                    break;
                }

                visited[y][x] = true;

                for (int i = 0; i < 4; i++) {
                    int dy = y + directions[i][0];
                    int dx = x + directions[i][1];

                    if (dy >= 0 && dy < N && dx >= 0 && dx < N) {
                        if (!visited[dy][dx] && costs[dy][dx] > cost + matrix[dy][dx]) {
                            costs[dy][dx] = cost + matrix[dy][dx];
                            pq.offer(new Node(dy, dx, costs[dy][dx]));
                        }
                    }
                }
            }
        }

        System.out.println(sb);
    }

}
