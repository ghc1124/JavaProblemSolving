package baekjoon.no2447;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static char[][] star;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        star = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                star[i][j] = '*';
            }
        }

        recursive(0, 0, N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(star[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void recursive(int startRow, int startCol, int N) {
        if (N == 1) return;

        for (int i = startRow + N / 3; i < startRow + N / 3 * 2; i++) {
            for (int j = startCol + N / 3; j < startCol + N / 3 * 2; j++) {
                star[i][j] = ' ';
            }
        }

        recursive(startRow, startCol, N / 3);
        recursive(startRow, startCol + N / 3, N / 3);
        recursive(startRow, startCol + N / 3 * 2, N / 3);
        recursive(startRow + N / 3, startCol, N / 3);
        recursive(startRow + N / 3, startCol + N / 3 * 2, N / 3);
        recursive(startRow + N / 3 * 2, startCol, N / 3);
        recursive(startRow + N / 3 * 2, startCol + N / 3, N / 3);
        recursive(startRow + N / 3 * 2, startCol + N / 3 * 2, N / 3);
    }

}
