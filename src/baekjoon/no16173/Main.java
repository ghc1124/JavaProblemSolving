package baekjoon.no16173;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] map;
    private static boolean[][] visited;
    private static int[][] directions = { { 1, 0 }, { 0, 1 }, };    // 아래쪽, 오른쪽
    private static String ans = "Hing";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());    // 크기

        StringTokenizer tokenizer = null;

        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        dfs(0, 0, N);

        System.out.println(ans);
    }

    private static void dfs(int y, int x, int N) {
        visited[y][x] = true;

        if (y == N - 1 && x == N - 1) {
            ans = "HaruHaru";
            return;
        }

        for (int i = 0; i < 2; i++) {
            int dy = y + directions[i][0] * map[y][x];
            int dx = x + directions[i][1] * map[y][x];

            if (dy >= 0 && dy < N && dx >= 0 && dx < N && !visited[dy][dx]) {
                dfs(dy, dx, N);
            }
        }
    }

}
