package baekjoon.no2563;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[][] whiteBoard = new int[100][100];
        int numOfPaper = Integer.parseInt(reader.readLine());
        int result = 0;

        while (numOfPaper-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int col = Integer.parseInt(tokenizer.nextToken());
            int row = Integer.parseInt(tokenizer.nextToken());

            for (int i = row; i < row + 10; i++) {
                for (int j = col; j < col + 10; j++) {
                    whiteBoard[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (whiteBoard[i][j] == 1) result++;
            }
        }

        System.out.println(result);
    }

}
