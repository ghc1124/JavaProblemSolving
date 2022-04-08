package swexpert.no1249;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution_ref {

    private static int N = 0, INF = Integer.MAX_VALUE;
    private static int map[][];
    private static int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());        // 테스트케이스 개수

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(reader.readLine());    // 지도 크기
            map = new int[N][N];
            boolean[][] visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                char[] temp = reader.readLine().toCharArray();
                for (int j = 0; j < N; j++) {
                    map[i][j] = temp[j] - '0';
                }
            }

            sb.append("#").append(t + 1).append(" ");
            sb.append(dijkstra(0, 0)).append("\n");
        }

        System.out.println(sb);
    }

    private static int dijkstra(int startR, int startC) {
        boolean[][] visited = new boolean[N][N];
        int[][] minTime = new int[N][N];    // 출발지에서 자신까지의 최소 복구 시간

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                minTime[i][j] = INF;
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> o1[2] - o2[2]));
        minTime[startR][startC] = 0;
        pq.offer(new int[] { startR, startC, minTime[startR][startC] });

        int r, c, minCost, dy, dx, current[];

        while (true) {
            current = pq.poll();
            r = current[0];
            c = current[1];
            minCost = current[2];

            if (visited[r][c]) continue;

            visited[r][c] = true;

            if (r == N - 1 && c == N - 1) return minCost;

            for (int i = 0; i < 4; i++) {
                dy = r + directions[i][0];
                dx = c + directions[i][1];

                if (dy >= 0 && dy < N && dx >= 0 && dx < N) {
                    if (!visited[dy][dx] && minTime[dy][dx] > minTime[r][c] + map[dy][dx]) {
                        minTime[dy][dx] =minTime[r][c] + map[dy][dx];
                    }
                }
            }
        }
    }

}
