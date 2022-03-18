package baekjoon.no16967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int H = Integer.parseInt(tokenizer.nextToken()); // 행
        int W = Integer.parseInt(tokenizer.nextToken()); // 열
        int X = Integer.parseInt(tokenizer.nextToken()); // 행 이동
        int Y = Integer.parseInt(tokenizer.nextToken()); // 열 이동

        int[][] temp = new int[H + X][W + Y]; // 타겟 배열
        for (int i = 0; i < H + X; i++) { // 배열 초기화
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < W + Y; j++) {
                temp[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        for (int i = X; i < H; i++) {
            for (int j = Y; j < W; j++) {
                temp[i][j] = temp[i][j] - temp[i - X][j - Y];
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                sb.append(temp[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

}
