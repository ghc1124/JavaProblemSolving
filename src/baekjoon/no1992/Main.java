package baekjoon.no1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        char[][] matrix = new char[N][N];

        for (int i = 0; i < N; i++) {
            matrix[i] = reader.readLine().toCharArray();
        }

        recursive(matrix, N, 0, 0);

        System.out.println(sb);
    }

    private static void recursive(char[][] matrix, int N, int startRow, int startCol) {
        if (N == 1) {
            sb.append(matrix[startRow][startCol]);
            return;
        }

        char check = matrix[startRow][startCol];
        boolean flag = true;

        Outer: for (int i = startRow; i < N + startRow; i++) {
            for (int j = startCol; j < N + startCol; j++) {
                if (matrix[i][j] != check) {
                    flag = false; // 통합 불가
                    break Outer;
                }
            }
        }

        if (flag) {
            sb.append(check);
            return;
        }

        sb.append("(");
        recursive(matrix, N / 2, startRow, startCol);
        recursive(matrix, N / 2, startRow, startCol + N / 2);
        recursive(matrix, N / 2, startRow + N / 2, startCol);
        recursive(matrix, N / 2, startRow + N / 2, startCol + N / 2);
        sb.append(")");
    }

}
