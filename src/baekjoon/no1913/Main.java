package baekjoon.no1913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(reader.readLine());
        int target = Integer.parseInt(reader.readLine());
        int[][] directions = {
                { -1, 0 },
                { 0, 1 },
                { 1, 0 },
                { 0, -1 },
        };

        int[][] matrix = new int[N][N];

        int direction = 0;
        int count = 1;
        int round = 0;
        int row = N / 2;
        int col = N / 2;
        int num = 1;

        while (num <= N * N) {
            for (int i = 0; i < count - 1; i++) {
                matrix[row][col] = num++;
                row += directions[direction % 4][0];
                col += directions[direction % 4][1];
            }
            matrix[row][col] = num++;
            row += directions[direction % 4][0]; // 다음 방향으로 셋팅
            col += directions[direction % 4][1]; // 다음 방향으로 셋팅
            direction++; // 방향 벡터 변수 증가

            if (round++ > 0 && round % 2 == 0) {
                count++;
            }
        }

        int temp_x = 0;
        int temp_y = 0;

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                sb.append(matrix[x][y]).append(" ");
                if (matrix[x][y] == target) {
                    temp_x = x;
                    temp_y = y;
                }
            }
            sb.append("\n");
        }
        sb.append(temp_x + 1).append(" ").append(temp_y + 1);

        System.out.println(sb);
    }

}
