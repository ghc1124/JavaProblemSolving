package baekjoon.no16918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int R = Integer.parseInt(tokenizer.nextToken()); // 행
        int C = Integer.parseInt(tokenizer.nextToken()); // 열
        int N = Integer.parseInt(tokenizer.nextToken()); // 시간

        int[][] directions = {
                { -1, 0 }, // 위
                { 1, 0 },  // 아래
                { 0, -1 }, // 왼쪽
                { 0, 1 },  // 오른쪽
        };

        char[][] matrix = new char[R][C]; // 원본 배열(N이 1일때)
        for (int i = 0; i < R; i++) {
            matrix[i] = reader.readLine().toCharArray();
        }

        char[][] fullMatrix = new char[R][C]; // N이 짝수일 때 꽉 찬 배열
        char[][] remain3Matrix = new char[R][C]; // N이 1 초과이고 4로 나눈 나머지가 3일 때의 배열
        char[][] remain1Matrix = new char[R][C]; // N이 1 초과이고 4로 나눈 나머지가 1일 때의 배열
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                fullMatrix[i][j] = 'O';
                remain3Matrix[i][j] = 'O';
                remain1Matrix[i][j] = 'O';
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == 'O') {
                    for (int k = 0; k < 4; k++) {
                        int dy = i + directions[k][0];
                        int dx = j + directions[k][1];

                        if (dy >= 0 && dy < R && dx >= 0 && dx < C) {
                            remain3Matrix[dy][dx] = '.';
                        }
                    }
                    remain3Matrix[i][j] = '.';
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (remain3Matrix[i][j] == 'O') {
                    for (int k = 0; k < 4; k++) {
                        int dy = i + directions[k][0];
                        int dx = j + directions[k][1];

                        if (dy >= 0 && dy < R && dx >= 0 && dx < C) {
                            remain1Matrix[dy][dx] = '.';
                        }
                    }
                    remain1Matrix[i][j] = '.';
                }
            }
        }

        char[][] answer;
        if (N == 1) answer = matrix;
        else if (N % 2 == 0) answer = fullMatrix;
        else if (N % 4 == 3) answer = remain3Matrix;
        else answer = remain1Matrix;


        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(answer[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

}