package baekjoon.no1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int answer = 0;
    private static int[][] arr = {
            { 0, 1 },
            { 2, 3 },
    };

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int r = Integer.parseInt(tokenizer.nextToken());
        int c = Integer.parseInt(tokenizer.nextToken());

        recursiveCall(N, r, c);

        System.out.println(answer);
    }

    private static void recursiveCall(int N, int i, int j) {
        if (N == 1) {
            answer += arr[i][j];
            return;
        }

        int center = 1 << (N - 1);
        int right = 1 << ((N - 1) * 2);
        int bottom = 1 << ((N - 1) * 2 + 1);

        // 좌표의 위치 찾기
        if (i < center && j >= center) {
            // 1사분면
            j -= center;
            answer += right;
        } else if (i < center && j < center) {
            // 2사분면

        } else if (i >= center && j < center) {
            // 3 사분면
            i -= center;
            answer += bottom;
        } else {
            // 4 사분면
            i -= center;
            j -= center;
            answer += right + bottom;
        }

        recursiveCall(N - 1, i, j);
    }

}
