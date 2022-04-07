package swexpert.no5643;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_BFS {

    private static int N;
    private static int[][] adjMatrix;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(reader.readLine());

        for (int tc = 0; tc < TC; tc++) {
            N = Integer.parseInt(reader.readLine());
            int M = Integer.parseInt(reader.readLine());

            adjMatrix = new int[N + 1][N + 1];  // 1-base index
            StringTokenizer tokenizer = null;
            int a, b;

            for (int i = 0; i < M; i++) {       // 간선 정보 입력받아 인접행렬에 표현
                tokenizer = new StringTokenizer(reader.readLine());
                a = Integer.parseInt(tokenizer.nextToken());
                b = Integer.parseInt(tokenizer.nextToken());
                adjMatrix[a][b] = 1;
            }

            int answer = 0;
            for (int i = 1; i <= N; i++) {
                if (gtBFS(i, new boolean[N + 1]) + ltBFS(i, new boolean[N + 1]) == N - 1) answer++;
            }

            sb.append("#").append(tc + 1).append(" ");
            sb.append(answer);
        }

        System.out.println(sb);
    }

    private static int gtBFS(int start, boolean[] visited) {    // 자신보다 큰놈들 따라감
        int cnt = 0;    // 학생 수

        Queue<Integer> queue = new ArrayDeque<>();
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int i = 1; i <= N; i++) {
                if (!visited[i] && adjMatrix[curr][i] > 0) {
                    visited[i] = true;
                    cnt++;
                    queue.offer(i);
                }
            }
        }

        return cnt;
    }

    private static int ltBFS(int start, boolean[] visited) {    // 나에게서 나가는 놈들(행)
        int cnt = 0;    // 학생 수

        Queue<Integer> queue = new ArrayDeque<>();
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int i = 1; i <= N; i++) {
                if (!visited[i] && adjMatrix[i][curr] > 0) {    // 나에게로 들어오는 놈들(열)
                    visited[i] = true;
                    cnt++;
                    queue.offer(i);
                }
            }
        }

        return cnt;
    }

}
