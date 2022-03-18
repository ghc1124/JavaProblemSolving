package baekjoon.no2961;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[][] ingredient = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < 2; j++) {
                ingredient[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        combination(ingredient, 0, new boolean[N]);
        System.out.println(result);
    }

    private static void combination(int[][] ingredient, int start, boolean[] isSelected) {
        if (start > 0) {
            int S = 1, B = 0;

            // 계산 로직
            for (int i = 0; i < isSelected.length; i++) {
                if (isSelected[i]) {
                    S *= ingredient[i][0];
                    B += ingredient[i][1];
                }
            }

            result = Math.min(result, Math.abs(S - B));
        }

        for (int i = start; i < ingredient.length; i++) {
            isSelected[i] = true;
            combination(ingredient, i + 1, isSelected);
        }
    }

}