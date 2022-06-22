package baekjoon.no2630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int blue, white;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());    // 한 변의 길이
        StringTokenizer tokenizer = null;
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        square(0, 0, N);

        System.out.println(white + "\n" + blue);
    }

    private static void square(int y, int x, int length) {
        if (length == 1) {
            if (arr[y][x] == 0) white++;
            else blue++;
            return;
        }

        int sum = 0;
        for (int i = y; i < y + length; i++) {
            for (int j = x; j < x + length; j++) {
                sum += arr[i][j];
            }
        }

        if (sum == length * length) blue++;
        else if (sum == 0) white++;
        else {
            square(y, x, length / 2);
            square(y, x + length / 2, length / 2);
            square(y + length / 2, x, length / 2);
            square(y + length / 2, x + length / 2, length / 2);
        }
    }

}
