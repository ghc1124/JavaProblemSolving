package baekjoon.no17143;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static class Shark implements Comparable<Shark> {

        int r, c, s, d, z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }

        @Override
        public int compareTo(Shark o) {
            return o.z - this.z;
        }
    }

    private static List<Shark> sharkList = new ArrayList<>();
    private static int[][] directions = { { 0, 0 }, { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 }, };
    private static int R, C;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        R = Integer.parseInt(tokenizer.nextToken());    // 행
        C = Integer.parseInt(tokenizer.nextToken());    // 열
        int M = Integer.parseInt(tokenizer.nextToken());    // 상어 수
        
        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int r = Integer.parseInt(tokenizer.nextToken());    // 행
            int c = Integer.parseInt(tokenizer.nextToken());    // 열
            int s = Integer.parseInt(tokenizer.nextToken());    // 속력
            int d = Integer.parseInt(tokenizer.nextToken());    // 이동 방향(1: 위, 2: 아래, 3: 오른쪽, 4: 왼쪽)
            int z = Integer.parseInt(tokenizer.nextToken());    // 크기

            sharkList.add(new Shark(r, c, s, d, z));
        }

        int ans = 0;

        if (M > 0) {
            Collections.sort(sharkList);

            for (int i = 1; i <= C; i++) {
                int r = R + 1;
                int idx = -1;

                // 잡고
                for (int j = 0; j < sharkList.size(); j++) {
                    Shark temp = sharkList.get(j);
                    if (temp.c == i && temp.r < r) {
                        r = temp.r;
                        idx = j;
                    }
                }

                if (idx != -1) {
                    ans += sharkList.get(idx).z;
                    sharkList.remove(idx);
                }

                // 이동
                moveShark();
            }
        }

        System.out.println(ans);
    }

    private static void moveShark() {
        int[][] shark = new int[R + 1][C + 1];

        // 리스트 순환하며 상어 위치 업데이트하고 배열에도 업데이트
        // 배열 업데이트 할 때 겹치는 경우 처리(상어의 크기 순으로 정렬하면 편할듯)
        for (int i = 0; i < sharkList.size(); i++) {
            Shark temp = sharkList.get(i);

            int speed = temp.s;
            if (speed > 0) {
                if (temp.d == 1 || temp.d == 2) speed %= (R - 1) * 2;
                else speed %= (C - 1) * 2;
            }

            int dy = temp.r;
            int dx = temp.c;

            for (int j = 0; j < speed; j++) {
                dy += directions[temp.d][0];
                dx += directions[temp.d][1];

                if (dy < 1 || dy > R || dx < 1 || dx > C) {
                    dy -= directions[temp.d][0];
                    dx -= directions[temp.d][1];
                    if (temp.d % 2 != 0) temp.d++;
                    else temp.d--;
                    j--;
                }
            }

            if (shark[dy][dx] != 0) {
                // 이미 다른 상어가 있는 경우(크기 순 내림차순 정렬이므로 더 큰 상어가 있다는 뜻)
                sharkList.remove(i--);
            }

            shark[dy][dx] = temp.z;
            temp.r = dy;
            temp.c = dx;
        }
    }

}
