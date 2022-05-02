package baekjoon.no2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 }, };
    private static int[][] map;
    private static int N, cnt;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine());    // 지도의 크기

        map = new int[N][N];
        String[] temp = {};
        for (int i = 0; i < N; i++) {
            temp = reader.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    cnt = 0;
                    dfs(i, j);
                    list.add(cnt);
                }
            }
        }

        Collections.sort(list);

        sb.append(list.size()).append("\n");

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int y, int x) {
        map[y][x] = 0;
        cnt++;

        for (int i = 0; i < 4; i++) {
            int dy = y + directions[i][0];
            int dx = x + directions[i][1];

            if (dy >= 0 && dy < N && dx >= 0 && dx < N) {
                if (map[dy][dx] == 1) dfs(dy, dx);
            }
        }
    }

}
