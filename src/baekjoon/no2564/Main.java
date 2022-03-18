package baekjoon.no2564;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int M = Integer.parseInt(tokenizer.nextToken());
        int N = Integer.parseInt(tokenizer.nextToken());
        int storeCount = Integer.parseInt(reader.readLine());
        int result = 0;

        int[][] map = new int[storeCount][2];

        // 1: 북, 2: 남, 3: 서, 4: 동

        // 상점 위치
        for (int i = 0; i < storeCount; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < 2; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        // 동근이 위치
        tokenizer = new StringTokenizer(reader.readLine());
        int dong_i = Integer.parseInt(tokenizer.nextToken());
        int dong_j = Integer.parseInt(tokenizer.nextToken());

        int mod = 0; // 0: 위, 1: 아래, 2: 왼쪽, 3: 오른쪽
        int left = 0, right = 0; // 양 사이드
        int opposite = 0; // 반대

        switch (dong_i) {
            case 1:
                mod = 1;
                left = 4;
                right = 3;
                opposite = 2;
                break;

            case 2:
                mod = 0;
                left = 3;
                right = 4;
                opposite = 1;
                break;

            case 3:
                mod = 2;
                left = 1;
                right = 2;
                opposite = 4;
                break;

            case 4:
                mod = 3;
                left = 2;
                right = 1;
                opposite = 3;
                break;
        }

        for (int i = 0; i < storeCount; i++) {
            int location = map[i][0];
            int value = map[i][1];

            if (location == dong_i) {
                result += Math.abs(dong_j - value);
            } else if (location == left) { // 동근이 기준 왼쪽
                switch (location) {
                    case 1:
                        result += value + dong_j;
                        break;

                    case 2:
                        result += (M - value) + (N - dong_j);
                        break;

                    case 3:
                        result += (N - value) + dong_j;
                        break;

                    case 4:
                        result += value + (M - dong_j);
                        break;
                }
            } else if (location == right) {
                switch (location) {
                    case 1:
                        result += (M - value) + dong_j;
                        break;

                    case 2:
                        result += value + (N - dong_j);
                        break;

                    case 3:
                        result += dong_j + value;
                        break;

                    case 4:
                        result += (N - value) + (M - dong_j);
                        break;
                }
            } else if (location == opposite) {
                result += Math.min(value + dong_j, (M - value) + (M - dong_j));
                switch (location) {
                    case 1:
                    case 2:
                        result += N;
                        break;

                    case 3:
                    case 4:
                        result += M;
                        break;
                }
            }
        }

        System.out.println(result);
    }

}
