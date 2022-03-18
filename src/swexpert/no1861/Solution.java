package swexpert.no1861;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    private static int cnt = 1;
    private static int[][] directions = {
            { -1, 0 },  // 상
            { 1, 0 },   // 하
            { 0, -1 },  // 좌
            { 0, 1 },   // 우
    };

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine()); // 테케 개수
        int problemNum = 1;

        while (T-- > 0) {
            int result = 0;
            int resultIndex = Integer.MAX_VALUE;
            int N = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[N + 1][N + 1]; // 인덱스는 1, 1부터!
            for (int i = 1; i <= N; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 1; j <= N; j++) {
                    matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    int temp = bfs(matrix, N, i, j);
                    // cnt = 1;
                    // dfs(matrix, N, i, j);
                    if (temp > result) {
                        result = temp;
                        resultIndex = matrix[i][j];
                    } else if (temp == result) {
                        resultIndex = Math.min(resultIndex, matrix[i][j]);
                    }
                }
            }
            sb.append("#").append(problemNum++).append(" ");
            sb.append(resultIndex).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static int bfs(int[][] matrix, int N, int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { i, j }); // 좌표값을 가지고 있음

        int count = 1;

        // 큐에 값이 존재할 동안
        while (!queue.isEmpty()) {
            int[] current = queue.poll(); // 탐색 대상

            for (int k = 0; k < 4; k++) {
                int dx = current[0] + directions[k][0];
                int dy = current[1] + directions[k][1];

                if (dx >= 1 && dx <= N && dy >= 1 && dy <= N) {
                    if (matrix[dx][dy] == matrix[current[0]][current[1]] + 1) {
                        queue.offer(new int[] { dx, dy });
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private static void dfs(int[][] matrix, int N, int i, int j) {
        if (!(i >= 1 && i <= N && j >= 1 && j <= N)) return;

        for (int k = 0; k < 4; k++) {
            int dx = i + directions[k][0];
            int dy = j + directions[k][1];

            if (dx >= 1 && dx <= N && dy >= 1 && dy <= N) {
                if (matrix[dx][dy] == matrix[i][j] + 1) {
                    cnt++;
                    dfs(matrix, N, dx, dy);
                }
            }
        }
    }

}
