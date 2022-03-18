package baekjoon.no1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int result;
    private static int temp;

    private static int[][] directions = {
            { -1, 0 },  // 상
            { 1, 0 },   // 하
            { 0, -1 },  // 좌
            { 0, 1 },   // 우
    };
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int R = Integer.parseInt(tokenizer.nextToken());
        int C = Integer.parseInt(tokenizer.nextToken());
        char[][] board = new char[R][C];
        for (int i = 0; i < R; i++) {
            board[i] = reader.readLine().toCharArray();
        }

        boolean[] flag = new boolean[26]; // 'A' -> 0

        dfs(board, flag, 0, 0, R, C);

        System.out.println(result);
    }

    private static void dfs(char[][] board, boolean[] flag, int row, int col, int R, int C) {
        flag[board[row][col] - 'A'] = true; // 사용 처리
        temp++;

        for (int i = 0; i < 4; i++) {
            int dy = row + directions[i][0];
            int dx = col + directions[i][1];

            if (dy >= 0 && dy < R && dx >= 0 && dx < C) {
                if (!flag[board[dy][dx] - 'A']) {
                    dfs(board, flag, dy, dx, R, C);
                }
            }
        }

        flag[board[row][col] - 'A'] = false; // 사용 처리
        result = Math.max(result, temp);
        temp--;
    }

}
