package baekjoon.no2636;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int W = Integer.parseInt(tokenizer.nextToken()); // 행
        int H = Integer.parseInt(tokenizer.nextToken()); // 열

        int[][] matrix = new int[W][H];
        for (int i = 0; i < W; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < H; j++) {
                matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        cutEdge(matrix, W, H);

        for (int i = 0; i < W; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    private static void cutEdge(int[][] matrix, int W, int H) {
        // 좌 -> 우
        for (int i = 0; i < W; i++) {
            boolean flag = false;
            for (int j = 0; j < H; j++) {
                if (matrix[i][j] == 1 && !flag) {
                    matrix[i][j] = 0;
                    flag = true;
                } else if (matrix[i][j] == 0 && flag) {
                    flag = false;
                }
            }
        }

        // 우 -> 좌
        for (int i = W - 1; i >= 0; i--) {
            boolean flag = false;
            for (int j = H - 1; j >= 0; j--) {
                if (matrix[i][j] == 1 && !flag) {
                    matrix[i][j] = 0;
                    flag = true;
                } else if (matrix[i][j] == 0 && flag) {
                    flag = false;
                }
            }
        }

        /*// 상 -> 하
        for (int i = 0; i < W; i++) {
            for (int j = 0; j < H; j++) {

            }
        }

        // 하 -> 상
        for (int i = 0; i < W; i++) {
            for (int j = 0; j < H; j++) {

            }
        }*/
    }

}
