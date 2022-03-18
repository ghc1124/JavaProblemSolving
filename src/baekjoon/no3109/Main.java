package baekjoon.no3109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] directions = {
            { -1, 1 }, // 오른쪽 위
            { 0, 1 },  // 오른쪽
            { 1, 1 },  // 오른쪽 아래
    };

    private static boolean result;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int R = Integer.parseInt(tokenizer.nextToken()); // 행
        int C = Integer.parseInt(tokenizer.nextToken()); // 열
        char[][] matrix = new char[R][C]; // 배열 생성
        for (int i = 0; i < R; i++) {
            matrix[i] = reader.readLine().toCharArray();
        }

        int ans = 0; // 파이프라인 갯수

        for (int i = 0; i < R; i++) { // 각 행을 돌면서 반복
            result = false; // 플래그 초기화
            recursive(matrix, i, 0, R, C);
            if (result) ans++; // 파이프라인이 완성된 경우 카운트 증가
        }

        System.out.println(ans);
    }

    // 백트래킹
    private static void recursive(char[][] matrix, int row, int col, int R, int C) {
        // 앞에서 가능한 수인지 체크를 하고 넘긴다.
        if (col == C - 1) {
            result = true;
            matrix[row][col] = 'x';
            return;
        }

        // 첫 열에서 시작
        matrix[row][col] = 'x';

        for (int j = 0; j < 3; j++) {
            int dy = row + directions[j][0]; // 델타 증가
            int dx = col + directions[j][1]; // 델타 증가

            if (dy >= 0 && dy < R && dx >= 0 && dx < C) { // 가능한 좌표인지 확인 후
                if (matrix[dy][dx] != 'x') recursive(matrix, dy, dx, R, C); // x가 아닐 경우(가능한 경우) 재귀
                if (result) break; // 파이프라인이 완성된 경우 더 이상 돌지 않고 끝냄
            }
        }
    }

}
