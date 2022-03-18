package baekjoon.no2669;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[16];
        int maxX = 0;
        int maxY = 0;
        int count = 0;

        int index = 0;

        for (int i = 0; i < 4; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < 4; j++) {
                arr[index + j] = Integer.parseInt(tokenizer.nextToken());
            }
            maxX = Math.max(arr[index + 3], maxX); // 행
            maxY = Math.max(arr[index + 2], maxY); // 열
            index += 4;
        }

        int[][] matrix = new int[maxX][maxY];

        for (int i = 0; i < 16; i += 4) {
            int startX = arr[i + 1];
            int startY = arr[i];
            int endX = arr[i + 3];
            int endY = arr[i + 2];

            for (int j = startX; j < endX; j++) {
                for (int k = startY; k < endY; k++) {
                    matrix[j][k] = 1;
                }
            }
        }

        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                if (matrix[i][j] == 1) count++;
            }
        }

        System.out.println(count);
    }

}
