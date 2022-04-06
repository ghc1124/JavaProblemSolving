package baekjoon.no2239;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static List<int[]> target;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[][] sudoku = new int[9][9];

        target = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            char[] temp = reader.readLine().toCharArray();

            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = temp[j] - '0';
                if (sudoku[i][j] == 0) target.add(new int[] { i, j });
            }
        }

        dfs(sudoku, 0);

        System.out.println(sb);
    }

    private static void dfs(int[][] sudoku, int idx) {
        if (sb != null) return;

        if (idx == target.size()) {
            sb = new StringBuilder();

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(sudoku[i][j]);
                }
                sb.append("\n");
            }

            return;
        }

        int y = target.get(idx)[0];
        int x = target.get(idx)[1];

        boolean[] temp = new boolean[10];

        checkCross(sudoku, temp, y, x);
        checkInner(sudoku, temp, y / 3 * 3, x / 3 * 3);

        for (int k = 1; k < 10; k++) {
            if (!temp[k]) {
                sudoku[y][x] = k;
                dfs(sudoku, idx + 1);
                sudoku[y][x] = 0;   // 여기로 왔다 -> 무언가 잘못된 상황이므로 0으로 다시 바꿔줌
            }
        }
    }

    // 가로, 세로 체크
    private static void checkCross(int[][] sudoku, boolean[] temp, int r, int c) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[r][i] != 0) temp[sudoku[r][i]] = true;   // 같은 행 탐색

            if (sudoku[i][c] != 0) temp[sudoku[i][c]] = true;   // 같은 열 탐색
        }
    }

    // 내부 3x3 사각형 체크
    private static void checkInner(int[][] sudoku, boolean[] temp, int r, int c) {
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (sudoku[i][j] != 0) temp[sudoku[i][j]] = true;
            }
        }
    }

}
