package baekjoon.no16926;

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
        int[][] matrix = new int[N][M];

        int[][] directions = {
                { 0, 1 },
                { 1, 0 },
                { 0, -1 },
                { -1, 0 },
        };

        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        int square = Math.min(N, M) / 2;

        while (R-- > 0) {
            for (int i = 0; i < square; i++) {
                int startRow = i;
                int startCol = i;
                int endRow = N - 1 - i;
                int endCol = M - 1 - i;

                int index = 0;

                int x = startRow;
                int y = startCol;
                int save = matrix[startRow][startCol];

                while (index < directions.length) {
                    int dx = x + directions[index][0];
                    int dy = y + directions[index][1];

                    if (dx >= startRow && dx <= endRow && dy >= startCol && dy <= endCol) {
                        int current = matrix[dx][dy];
                        matrix[dx][dy] = save;
                        save = current;
                        x = dx;
                        y = dy;
                    } else {
                        index++;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(matrix[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}