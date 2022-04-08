package baekjoon.no14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int[][] map, directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    private static List<int[]> point, virus;
    private static int N, M, res;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());    // 세로(행)
        M = Integer.parseInt(tokenizer.nextToken());    // 가로(열)

        map = new int[N][M];                                // 연구소 지도
        point = new ArrayList<>();                          // 벽을 칠 수 있는 위치
        virus = new ArrayList<>();                          // 바이러스의 위치
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
                if (map[i][j] == 0) point.add(new int[] { i, j });
                else if (map[i][j] == 2) virus.add(new int[] { i, j });
            }
        }

        combination(new int[3], 0, point.size(), 0);

        System.out.println(res);
    }

    private static void combination(int[] target, int current, int size, int cnt) {
        if (cnt == 3) {
            // 3개 뽑음 -> 벽을 칠 위치. 벽 치고 나서 바이러스 위치에서 DFS 수행
            for (int i = 0; i < 3; i++) {
                int[] curr = point.get(target[i]);
                map[curr[0]][curr[1]] = 1;
            }

            int[][] arr = new int[N][M];
            for (int r = 0; r < N; r++) {
                arr[r] = map[r].clone();
            }

            // 벽치기 끝
            // 바이러스의 모든 위치에서 dfs 수행
            for (int i = 0; i < virus.size(); i++) {
                dfs(virus.get(i), arr);
            }

            res = Math.max(res, calcSafetyArea(arr));

            // 원상복구
            for (int i = 0; i < 3; i++) {
                int[] curr = point.get(target[i]);
                map[curr[0]][curr[1]] = 0;
            }

            return;
        }

        for (int i = current; i < size; i++) {
            target[cnt] = i;
            combination(target, i + 1, size, cnt + 1);
        }
    }

    private static void dfs(int[] code, int[][] arr) {
        for (int i = 0; i < 4; i++) {
            int dy = code[0] + directions[i][0];
            int dx = code[1] + directions[i][1];

            if (dy >= 0 && dy < N && dx >= 0 && dx < M) {
                if (arr[dy][dx] == 0) {
                    arr[dy][dx] = 2;
                    dfs(new int[] { dy, dx }, arr);
                }
            }
        }
    }

    private static int calcSafetyArea(int[][] arr) {
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) cnt++;
            }
        }

        return cnt;
    }

}
