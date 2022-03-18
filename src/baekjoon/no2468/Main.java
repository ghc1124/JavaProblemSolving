package baekjoon.no2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] directions = {
            { -1, 0  }, // 상
            {  1, 0  }, // 하
            {  0, -1 }, // 좌
            {  0, 1  }, // 우
    };

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine()); // 행, 열의 수
        int[][] matrix = new int[N][N];
        int maxValue = 0;
        // 배열 생성
        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                maxValue = Math.max(maxValue, matrix[i][j]);
            }
        }

        int max = 1;

        for (int k = 1; k < maxValue; k++) {
            int temp = 0;
            boolean[][] flag = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (matrix[i][j] > k && !flag[i][j]) {
                        temp++;
                        flag[i][j] = true;
                        dfs(k, i, j, N, matrix, flag);
                    }
                }
            }
            max = Math.max(max, temp);
        }

        System.out.println(max);
    }

    private static void dfs(int height, int row, int col, int N, int[][] matrix, boolean[][] flag) {
        for (int i = 0; i < 4; i++) {
            int dy = row + directions[i][0];
            int dx = col + directions[i][1];

            // 가능한 인덱스이고
            if (dy >= 0 && dy < N && dx >= 0 && dx < N) {
                // 물에 잠기지 않은 곳이면
                if (matrix[dy][dx] > height && !flag[dy][dx]) {
                    flag[dy][dx] = true;
                    dfs(height, dy, dx, N, matrix, flag);
                }
            }
        }
    }

}
