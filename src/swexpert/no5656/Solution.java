package swexpert.no5656;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 }};
    private static int N, W, H, min; // min -> 남은 벽돌의 최소

    private static class Point { // 벽돌 정보

        int r, c, cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }

    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            N = Integer.parseInt(tokenizer.nextToken());
            W = Integer.parseInt(tokenizer.nextToken()); // 열
            H = Integer.parseInt(tokenizer.nextToken()); // 행

            int[][] matrix = new int[H][W];

            for (int i = 0; i < H; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < W; j++) {
                    matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            min = Integer.MAX_VALUE;

            go(0, matrix);

            sb.append("#").append(t + 1).append(" ");
            sb.append(min).append("\n");
        }

        System.out.println(sb);
    }

    private static boolean go(int count, int[][] matrix) {         // 중복순열 이용 구슬 던지기(count: 구슬을 던진 횟수
        int result = getRemain(matrix);

        if (result == 0) {  // 모든 벽돌이 다 부서진 경우
            min = 0;
            return true;    // 다 부서짐
        }

        if (count == N) {   // 모든 구슬을 다 던졌다면
            min = Math.min(min, result);

            return false;   // 아직 벽돌이 남아있음
        }

        int[][] newMatrix = new int[H][W];

        // 0열부터 W-1열까지 구슬 던져보기
        for (int c = 0; c < W; c++) {
            // 구슬에 맞는 벽돌 찾기
            int r = 0;
            while (r < H && matrix[r][c] == 0) ++r; // 빈 공간이면 계속 이동

            // 벽돌이 없는 경우
            if (r == H) continue;

            // 배열의 상태를 백업
            copy(matrix, newMatrix);

            // 벽돌을 찾은 경우
            boom(newMatrix, r, c);  // 연쇄 처리

            down(newMatrix);

            if (go(count + 1, newMatrix)) return true;    // 다음 구슬 처리
        }

        return false;                                           // 다 부서지는 경우가 없음
    }

    private static void boom(int[][] matrix, int r, int c) {    // r, c 위치에서 주변의 가능한 모든 벽돌 부수기
        // BFS
        Queue<Point> queue = new ArrayDeque<>();
        if (matrix[r][c] > 1) {
            queue.offer(new Point(r, c, matrix[r][c]));
        }

        matrix[r][c] = 0; // 자신 제거

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            // 4방 탐색
            for (int d = 0; d < 4; d++) {
                int dy = point.r;
                int dx = point.c;

                for (int i = 0; i < point.cnt - 1; i++) {       // 벽돌의 크기-1 만큼 이동
                    dy += directions[d][0];
                    dx += directions[d][1];

                    if (dy >= 0 && dy < H && dx >= 0 && dx < W && matrix[dy][dx] > 0) {
                        if (matrix[dy][dx] > 1) {               // 다른 벽돌에 영향을 주는(1초과) 벽돌인 경우
                            queue.offer(new Point(dy, dx, matrix[dy][dx]));
                        }
                        matrix[dy][dx] = 0;                     // 벽돌 처리
                    }
               }
            }
        }
    }

    private static List<Integer> temp = new ArrayList<>();

    private static void down(int[][] matrix) {                  // 남은 벽돌을 밑으로 정리
        for (int c = 0; c < W; c++) {
            int r = H - 1;  // 아래행부터 시작
            while (r >= 0) {
                if (matrix[r][c] > 0) {                         // 벽돌 찾기
                    temp.add(matrix[r][c]);                     // 전체 정리 후 다시 배치
                    matrix[r][c] = 0;
                }
                r--;
            }   // 부서지지 않고 남아있는 벽돌을 리스트에 다 담고, 벽돌이 있던 원래 자리는 빈공간으로 처리가 된다.

            r = H - 1;
            for (int n : temp) {
                matrix[r--][c] = n;                               // 밑에서부터 채우기
            }

            temp.clear();
        }
    }

    private static int getRemain(int[][] matrix) {              // 남은 벽돌 수 리턴
        int count = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (matrix[i][j] > 0) count++;
            }
        }

        return count;
    }

    private static void copy(int[][] matrix, int[][] newMatrix) {
        for (int i = 0; i < H; i++) {
            newMatrix[i] = matrix[i].clone();
        }
    }

}
