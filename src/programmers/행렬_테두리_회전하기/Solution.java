package programmers.행렬_테두리_회전하기;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        solution(3, 3, new int[][] { { 1, 1, 2, 2 }, { 1, 2, 2, 3 }, { 2, 1, 3, 2 }, { 2, 2, 3, 3 } });
    }

    private static void solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] matrix = new int[rows][columns];

        int num = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = num++;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotate(matrix, queries[i][0] - 1, queries[i][1] - 1, queries[i][2] - 1, queries[i][3] - 1);
        }

        System.out.println(Arrays.toString(answer));
    }

    private static int rotate(int[][] matrix, int y1, int x1, int y2, int x2) {
        int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }, };

        int first = matrix[y1][x1];
        int dy = y1 + 1;
        int dx = x1;

        int index = 0;

        int min = Integer.MAX_VALUE;

        matrix[y1][x1] = matrix[dy][dx];
        min = Math.min(min, matrix[dy][dx]);

        while (dy != y1 || dx != x1 + 1) {
            int tempY = dy + directions[index][0];
            int tempX = dx + directions[index][1];

            if (tempY >= y1 && tempY <= y2 && tempX >= x1 && tempX <= x2) {
                matrix[dy][dx] = matrix[tempY][tempX];
                min = Math.min(min, matrix[tempY][tempX]);
                dy = tempY;
                dx = tempX;
            } else {
                index++;
            }
        }

        matrix[y1][x1 + 1] = first;
        min = Math.min(min, first);

        return min;
    }

}
