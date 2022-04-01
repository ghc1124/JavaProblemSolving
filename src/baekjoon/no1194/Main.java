package baekjoon.no1194;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static class Node {

        int row;
        int col;
        int cnt;
        int keyStatus;

        public Node(int row, int col, int cnt, int keyStatus) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
            this.keyStatus = keyStatus;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

        int N = Integer.parseInt(tokenizer.nextToken()); // 세로(행)
        int M = Integer.parseInt(tokenizer.nextToken()); // 가로(열)

        int startR = 0, startC = 0;
        boolean flag = false;

        char[][] matrix = new char[N][M];
        for (int i = 0; i < N; i++) {
            matrix[i] = reader.readLine().toCharArray();
            if (!flag) {
                for (int j = 0; j < M; j++) {
                    if (matrix[i][j] == '0') {
                        startR = i;
                        startC = j;
                        flag = true;
                        break;
                    }
                }
            }
        }

        boolean[][][] visited = new boolean[N][M][64];

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(startR, startC, 0, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (visited[node.row][node.col][node.keyStatus]) continue;
            if (matrix[node.row][node.col] == '1') {
                System.out.println(node.cnt);
                return;
            }

            visited[node.row][node.col][node.keyStatus] = true;

            for (int i = 0; i < 4; i++) {
                int dy = node.row + directions[i][0];
                int dx = node.col + directions[i][1];

                if (dy >= 0 && dy < N && dx >= 0 && dx < M) {
                    if (visited[dy][dx][node.keyStatus]) continue;
                    if (matrix[dy][dx] == '.' || matrix[dy][dx] == '0' || matrix[dy][dx] == '1') queue.offer(new Node(dy, dx, node.cnt + 1, node.keyStatus));
                    else if (matrix[dy][dx] >= 'a' && matrix[dy][dx] <= 'f') queue.offer(new Node(dy, dx, node.cnt + 1, node.keyStatus | 1 << matrix[dy][dx] - 'a'));
                    else if (matrix[dy][dx] >= 'A' && matrix[dy][dx] <= 'F') {
                        if ((node.keyStatus & 1 << matrix[dy][dx] - 'A') != 0) {
                            queue.offer(new Node(dy, dx, node.cnt + 1, node.keyStatus));
                        }
                    }
                }
            }
        }

        System.out.println(-1);
    }

}
