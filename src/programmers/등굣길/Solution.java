package programmers.등굣길;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(7, 4, new int[][] {{ 2, 1 }, { 2, 2 }, { 2, 3 }, { 4, 2 }, { 4, 3 }, { 4, 4 }, { 6, 2 }, { 6, 3 },}));
    }

    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;

        int[][] map = new int[n + 1][m + 1]; // 1-base index
        /**
         * 시작 -> 1, 1(1행 1열)
         * 끝 -> m, n(n행 m열)
         */

        int[][] directions = {
                { -1, 0 }, // 윗쪽
                { 0, -1 }, // 왼쪽
        };

        if (puddles[0].length > 0) {
            for (int i = 0, size = puddles.length; i < size; i++) {
                int x = puddles[i][0];
                int y = puddles[i][1];

                map[y][x] = -1; // 웅덩이
            }
        }

        map[1][1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] != 0) continue;

                int[] temp = new int[2]; // 0번 -> 윗쪽, 1번 -> 왼쪽

                for (int k = 0; k < 2; k++) {
                    int dy = i + directions[k][0];
                    int dx = j + directions[k][1];

                    // 탐색 가능한 범위인 경우
                    if (dy > 0 && dy <= n && dx > 0 && dx <= m) {
                        temp[k] = map[dy][dx];
                    }
                }

                if (temp[0] == 0 || temp[1] == 0) {
                    map[i][j] = Math.max(temp[0], temp[1]) % 1000000007;
                } else if (temp[0] == -1 || temp[1] == -1) {
                    map[i][j] = Math.max(Math.max(temp[0], temp[1]), 0) % 1000000007;
                } else  map[i][j] = (temp[0] + temp[1]) % 1000000007;
            }
        }

        for (int[] row : map) System.out.println(Arrays.toString(row));

        answer = map[n][m];

        return answer;
    }

}
