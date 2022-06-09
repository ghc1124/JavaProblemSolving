package baekjoon.no2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 }, };

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());    // 행
        int M = Integer.parseInt(tokenizer.nextToken());    // 열

        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = reader.readLine().toCharArray();
        }

        boolean[][] isVisited = new boolean[N][M];

        int cnt = 0;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0, 1});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int y = curr[0];
            int x = curr[1];
            int length = curr[2];

            if (isVisited[y][x]) {
                continue;
            }

            isVisited[y][x] = true;

            if (y == N - 1 && x == M - 1) {
                cnt = length;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int dy = y + directions[i][0];
                int dx = x + directions[i][1];

                if (dy >= 0 && dy < N && dx >= 0 && dx < M && map[dy][dx] == '1' && !isVisited[dy][dx]) {
                    queue.offer(new int[] {dy, dx, length + 1});
                }
            }
        }

        System.out.println(cnt);
    }

}
