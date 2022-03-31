package baekjoon.no2636;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[][] directions = {
            { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 }
    };

    private static int[][] matrix;
    private static boolean[][] outside;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int R = Integer.parseInt(tokenizer.nextToken()); // 행
        int C = Integer.parseInt(tokenizer.nextToken()); // 열

        matrix = new int[R][C];
        int cnt = 0;
        for (int i = 0; i < R; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < C; j++) {
                matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                if (matrix[i][j] == 1) cnt++;
            }
        }

        int idx = 0;
        int ans = 0;

        while (cnt > 0) {
            outside = new boolean[R][C];

            Queue<int[]> findOutside = new ArrayDeque<>(); // 바깥 공기 찾기 BFS
            findOutside.offer(new int[] { 0, 0 });

            while (!findOutside.isEmpty()) {
                int[] curr = findOutside.poll();

                if (outside[curr[0]][curr[1]]) continue;

                outside[curr[0]][curr[1]] = true; // 외부공기

                for (int i = 0; i < 4; i++) {
                    int dy = curr[0] + directions[i][0];
                    int dx = curr[1] + directions[i][1];

                    if (dy >= 0 && dy < R && dx >= 0 && dx < C && matrix[dy][dx] == 0) {
                        findOutside.offer(new int[] { dy, dx });
                    }
                }
            }

            idx++;
            ans = cnt != 0 ? cnt : ans;

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (matrix[i][j] == 1) {
                        for (int x = 0; x < 4; x++) {
                            int dy = i + directions[x][0];
                            int dx = j + directions[x][1];

                            if (outside[dy][dx]) {
                                matrix[i][j] = 0;
                                cnt--;
                                break;
                            }
                        }
                    }
                }
            }

            /*for (int[] row : matrix) System.out.println(Arrays.toString(row));
            System.out.println();*/
        }

        System.out.println(idx + "\n" + ans);
    }

}
