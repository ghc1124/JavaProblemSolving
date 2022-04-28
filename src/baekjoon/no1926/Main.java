package baekjoon.no1926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 }, };
    private static int n, m;
    private static int[][] art;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(tokenizer.nextToken()); // 세로(행)
        m = Integer.parseInt(tokenizer.nextToken()); // 가로(열)

        art = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        int cnt = 0; // 그림의 개수
        int res = 0; // 최댓값

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < m; j++) {
                art[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (art[i][j] == 1 && !visited[i][j]) {
                    res = Math.max(res, bfs(visited, i, j));
                    cnt++;
                }
            }
        }

        System.out.println(cnt + "\n" + res);
    }

    private static int bfs(boolean[][] visited, int y, int x) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { y, x });

        int cnt = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            if (visited[r][c]) continue;

            visited[r][c] = true;
            cnt++;

            for (int i = 0; i < 4; i++) {
                int dy = r + directions[i][0];
                int dx = c + directions[i][1];

                if (dy >= 0 && dy < n && dx >= 0 && dx < m) {
                    if (art[dy][dx] == 1 && !visited[dy][dx]) queue.offer(new int[] { dy, dx });
                }
            }
        }

        return cnt;
    }

}
