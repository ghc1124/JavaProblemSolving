package baekjoon.no16935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        int R = Integer.parseInt(tokenizer.nextToken());
        int[][] target = new int[N][M];
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < M; j++) {
                target[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        tokenizer = new StringTokenizer(reader.readLine());
        int[] command = new int[R];
        int[][] result = new int[N][M];
        for (int i = 0; i < R; i++) {
            command[i] = Integer.parseInt(tokenizer.nextToken());
            switch (command[i]) {
                case 1:
                    result = calc1(target, N, M);
                    break;

                case 2:
                    result = calc2(target, N, M);
                    break;

                case 3:
                    result = calc3(target, N, M);
                    break;

                case 4:
                    result = calc4(target, N, M);
                    break;

                case 5:
                    result = calc5(target, N, M);
                    break;

                case 6:
                    result = calc6(target, N, M);
                    break;
            }

            target = result;
            N = target.length;
            M = target[0].length;
        }

        for (int[] row : result) {
            for (int col : row) {
                sb.append(col).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static int[][] calc1(int[][] target, int N, int M) {
        int[][] result = new int[N][M];

        for (int j = 0; j < M; j++) {
            for (int i = 0; i < N; i++) {
                result[i][j] = target[N - i - 1][j];
            }
        }

        return result;
    }

    private static int[][] calc2(int[][] target, int N, int M) {
        int[][] result = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                result[i][j] = target[i][M - j - 1];
            }
        }

        return result;
    }

    private static int[][] calc3(int[][] target, int N, int M) {
        int[][] result = new int[M][N];

        for (int j = 0; j < M; j++) {
            for (int i = 0; i < N; i++) {
                result[j][N - i - 1] = target[i][j];
            }
        }

        return result;
    }

    private static int[][] calc4(int[][] target, int N, int M) {
        int[][] result = new int[M][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                result[M - j - 1][i] = target[i][j];
            }
        }

        return result;
    }

    private static int[][] calc5(int[][] target, int N, int M) {
        int[][] result = new int[N][M];

        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) { // 1
                result[i][j + M / 2] = target[i][j];
            }
            for (int j = M / 2; j < M; j++) { // 2
                result[i + N / 2][j] = target[i][j];
            }
        }

        for (int i = N / 2; i < N; i++) { // 3
            for (int j = M / 2; j < M; j++) {
                result[i][j - M / 2] = target[i][j];
            }
            for (int j = 0; j < M / 2; j++) { // 4
                result[i - N / 2][j] = target[i][j];
            }
        }

        return result;
    }

    private static int[][] calc6(int[][] target, int N, int M) {
        int[][] result = new int[N][M];

        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) { // 1
                result[i + N / 2][j] = target[i][j];
            }
            for (int j = M / 2; j < M; j++) { // 2
                result[i][j - M / 2] = target[i][j];
            }
        }

        for (int i = N / 2; i < N; i++) {
            for (int j = M / 2; j < M; j++) { // 3
                result[i - N / 2][j] = target[i][j];
            }
            for (int j = 0; j < M / 2; j++) { // 4
                result[i][j + M / 2] = target[i][j];
            }
        }

        return result;
    }

}
