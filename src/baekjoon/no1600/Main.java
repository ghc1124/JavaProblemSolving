package baekjoon.no1600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[][] horse = {
            { 2, 1 }, { 1, 2 }, { -1, 2 }, { -2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 },
    };

    private static int[][] adj = {
            { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 },
    };

    private static class Node {

        int y;
        int x;
        int cnt;
        int k; // 남은 K

        public Node(int y, int x, int cnt, int k) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
            this.k = k;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(reader.readLine()); // 횟수

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int W = Integer.parseInt(tokenizer.nextToken()); // 가로길이(열)
        int H = Integer.parseInt(tokenizer.nextToken()); // 세로길이(행)

        int[][] matrix = new int[H][W];
        boolean[][][] visited = new boolean[H][W][K + 1];
        /**
         * visited 1번자리: 행, 2번자리: 열, 3번자리: 대각선 이동을 사용한 횟수
         */

        for (int i = 0; i < H; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < W; j++) {
                matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0, 0, 0, 0));

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            int y = curr.y;
            int x = curr.x;
            int cnt = curr.cnt;
            int k = curr.k;

            if (visited[y][x][k]) continue;
            visited[y][x][k] = true;

            if (y == (H - 1) && x == (W - 1)) {
                System.out.println(cnt);
                return;
            }

            // 대각선 이동
            if (k < K) {
                for (int i = 0; i < 8; i++) {
                    int dy = y + horse[i][0];
                    int dx = x + horse[i][1];

                    if (dy >= 0 && dy < H && dx >= 0 && dx < W) {
                        if (matrix[dy][dx] == 0 && !visited[dy][dx][k + 1]) {
                            queue.offer(new Node(dy, dx, cnt + 1, k + 1));
                        }
                    }
                }
            }

            // 인접 이동
            for (int i = 0; i < 4; i++) {
                int dy = y + adj[i][0];
                int dx = x + adj[i][1];

                if (dy >= 0 && dy < H && dx >= 0 && dx < W) {
                    if (matrix[dy][dx] == 0 && !visited[dy][dx][k]) {
                        queue.offer(new Node(dy, dx, cnt + 1, k));
                    }
                }
            }
        }

        System.out.println(-1);
    }

}
