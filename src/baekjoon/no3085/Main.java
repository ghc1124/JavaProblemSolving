package baekjoon.no3085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private String[][] matrix;

    public static void main(String[] args) throws IOException {
        // 탐색은 좌측 탐색, 우측 탐색. swap 후 최대값을 찾는다.
        // swap 대상을 찾으면 swap을 진행
        Main main = new Main();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        main.matrix = new String[N][N];
        int result = 0;
        for (int i = 0; i < N; i++) { // 배열에 저장
            main.matrix[i] = reader.readLine().split("");
        }
        // 제일 처음 상태 먼저 계산
        if (main.findMax(N) == N) {
            System.out.println(N);
        } else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N - 1; j++) {
                    // 행에서 다른게 있을 경우 swap
                    if (main.matrix[i][j] != main.matrix[i][j + 1]) {
                        main.swap(i, j, i, j + 1);
                        result = Math.max(result, main.findMax(N));
                        main.swap(i, j, i, j + 1);
                    }
                }
            }

            for (int j = 0; j < N; j++) {
                for (int i = 0; i < N - 1; i++) {
                    // 열에서 다른게 있을 경우 swap
                    if (main.matrix[i][j] != main.matrix[i + 1][j]) {
                        main.swap(i, j, i + 1, j);
                        result = Math.max(result, main.findMax(N));
                        main.swap(i, j, i + 1, j);
                    }
                }
            }
            System.out.println(result);
        }
    }

    private int findMax(int size) {
        // 배열을 둘러보며 최대치 찾기
        int result = 0;
        for (int i = 0; i < size; i++) {
            // 행
            int count = 1;
            for (int j = 0; j < size - 1; j++) {
                if (matrix[i][j].equals(matrix[i][j + 1])) {
                    count++;
                } else {
                    result = Math.max(result, count);
                    count = 1;
                }
            }
            result = Math.max(result, count);
        }

        for (int j = 0; j < size; j++) {
            // 열
            int count = 1;
            for (int i = 0; i < size - 1; i++) {
                if (matrix[i][j].equals(matrix[i + 1][j])) {
                    count++;
                } else {
                    result = Math.max(result, count);
                    count = 1;
                }
            }
            result = Math.max(result, count);
        }
        result = result == 1 ? 0 : result;
        return result;
    }

    private void swap(int x1, int y1, int x2, int y2) {
        String temp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = temp;
    }

}
