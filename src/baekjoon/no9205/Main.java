package baekjoon.no9205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());        // 테스트케이스

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(reader.readLine());    // 편의점 수

            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int houseX = Integer.parseInt(tokenizer.nextToken());    // 집 x 좌표
            int houseY = Integer.parseInt(tokenizer.nextToken());    // 집 y 좌표

            int[][] map = new int[n + 1][2];

            for (int i = 0; i < n + 1; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                int x1 = Integer.parseInt(tokenizer.nextToken());   // 편의점 x 좌표
                int y1 = Integer.parseInt(tokenizer.nextToken());   // 편의점 y 좌표

                map[i][0] = x1;
                map[i][1] = y1;
            }

            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[] { houseX, houseY });  // 처음 좌표 세팅

            String message = "sad";

            boolean[] visited = new boolean[n + 1];

            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];

                // 도착한 경우
                if (x == map[n][0] && y == map[n][1]) {
                    message = "happy";
                    break;
                }

                for (int i = 0; i < n + 1; i++) {
                    if (Math.abs(map[i][0] - x) + Math.abs(map[i][1] - y) <= 1000 && !visited[i]) {
                        visited[i] = true;
                        queue.offer(map[i]);
                    }
                }
            }

            sb.append(message).append("\n");
        }

        System.out.println(sb);
    }

}
