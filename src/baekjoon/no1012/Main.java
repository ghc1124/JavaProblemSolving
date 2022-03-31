package baekjoon.no1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int M = Integer.parseInt(tokenizer.nextToken()); // 가로길이(열)
            int N = Integer.parseInt(tokenizer.nextToken()); // 세로길이(행)
            int K = Integer.parseInt(tokenizer.nextToken()); // 배추 개수

            int[][] matrix = new int[N][M];

            for (int i = 0; i < K; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                int x = Integer.parseInt(tokenizer.nextToken());
                int y = Integer.parseInt(tokenizer.nextToken());
                matrix[y][x] = 1;
            }

            int cnt = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (matrix[i][j] == 1) {
                        cnt++;
                        bfs(matrix, N, M, i, j);
                    }
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int[][] matrix, int R, int C, int row, int col) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { row, col });

        int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 }, };
        boolean[][] visited = new boolean[R][C];

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            if (visited[curr[0]][curr[1]]) continue;

            visited[curr[0]][curr[1]] = true;
            matrix[curr[0]][curr[1]] = 0;

            for (int i = 0; i < 4; i++) {
                int dy = curr[0] + directions[i][0];
                int dx = curr[1] + directions[i][1];

                if (dy >= 0 && dy < R && dx >= 0 && dx < C) {
                    if (matrix[dy][dx] == 1 && !visited[dy][dx]) queue.offer(new int[] { dy, dx });
                }
            }
        }
    }

}
