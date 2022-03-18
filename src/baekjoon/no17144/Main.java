package baekjoon.no17144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 0 ~ 3 -> 위쪽 공기청정기, 4 ~ 7 -> 아래쪽 공기청정기
    private static int[][] directions = {
            { -1, 0 },  // 상
            { 0, 1 },   // 우
            { 1, 0 },   // 하
            { 0, -1 },  // 좌
            { 1, 0 },   // 하
            { 0, 1 },   // 우
            { -1, 0 },  // 상
            { 0, -1 },  // 좌
    };

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int R = Integer.parseInt(tokenizer.nextToken()); // 행
        int C = Integer.parseInt(tokenizer.nextToken()); // 열
        int T = Integer.parseInt(tokenizer.nextToken()); // 초

        int air = 0; // 최종적으로 두 행 중 밑의 행을 가리키게 됨. (air - 1, air) 두 행에 공기청정기 위치

        // 배열 채우기
        int[][] pm = new int[R][C];
        for (int i = 0; i < R; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < C; j++) {
                pm[i][j] = Integer.parseInt(tokenizer.nextToken());
                if (pm[i][j] == -1) air = i;
            }
        }

        for (int i = 0; i < T; i++) {
            pm = spread(pm, R, C); // -> T초동안 반복해야됨
            purify(pm, air - 1, air, R, C);
        }

        int sum = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sum += pm[i][j];
            }
        }

        System.out.println(sum + 2);
    }

    // 공기청정기 돌리기
    private static void purify(int[][] pm, int up, int down, int R, int C) {
        // 위쪽 돌리기
        // 시작점 세팅
        int dy = up - 1;
        int dx = 0;

        int index = 0;

        while (true) {
            dy += directions[index][0];
            dx += directions[index][1];

            if (dy == up && dx == 0) break; // 공기청정기에 닿았을 경우

            // 유효 인덱스 범위일 경우
            if (dy >= 0 && dy <= up && dx >= 0 && dx < C) {
                pm[dy - directions[index][0]][dx - directions[index][1]] = pm[dy][dx];
            } else {
                dy -= directions[index][0];
                dx -= directions[index][1];
                index++;
            }
        }

        pm[up][1] = 0;

        // 아래쪽 돌리기
        // 시작점 세팅
        dy = down + 1;
        dx = 0;

        index = 4;

        while (true) {
            dy += directions[index][0];
            dx += directions[index][1];

            if (dy == down && dx == 0) break; // 공기청정기에 닿았을 경우

            // 유효 인덱스 범위일 경우
            if (dy >= down && dy < R && dx >= 0 && dx < C) {
                pm[dy - directions[index][0]][dx - directions[index][1]] = pm[dy][dx];
            } else {
                dy -= directions[index][0];
                dx -= directions[index][1];
                index++;
            }
        }

        pm[down][1] = 0;
    }

    // 미세먼지의 확산
    private static int[][] spread(int[][] pm, int R, int C) {
        int[][] copyPM = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                copyPM[i][j] = pm[i][j];
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (pm[i][j] > 0) {
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int dy = i + directions[k][0];
                        int dx = j + directions[k][1];

                        if (dy >= 0 && dy < R && dx >= 0 && dx < C && pm[dy][dx] != -1) {
                            copyPM[dy][dx] += pm[i][j] / 5; // 확산된 위치의 미세먼지 값 업데이트
                            cnt++;
                        }
                    }
                    copyPM[i][j] -= pm[i][j] / 5 * cnt; // 현재 위치의 미세먼지 값 업데이트
                }
            }
        }

        return copyPM;
    }

}
