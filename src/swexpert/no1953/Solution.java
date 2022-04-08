package swexpert.no1953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    private static class Node {

        int y;
        int x;
        int type;

        public Node(int y, int x, int type) {
            this.y = y;
            this.x = x;
            this.type = type;
        }

    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());    // 테스트케이스 개수

        int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

        for (int t = 0; t < T; t++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

            int N = Integer.parseInt(tokenizer.nextToken());    // 세로 크기(행)
            int M = Integer.parseInt(tokenizer.nextToken());    // 가로 크기(열)
            int R = Integer.parseInt(tokenizer.nextToken());    // 세로 위치(행)
            int C = Integer.parseInt(tokenizer.nextToken());    // 가로 위치(열)
            int L = Integer.parseInt(tokenizer.nextToken());    // 시간

            int[][] map = new int[N][M];
            boolean[][] visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }
            /**
             * 단계별 BFS 수행하여 특정 레벨(L)에 도달한 경우의 수 구하기
             */
            Queue<Node> queue = new ArrayDeque<>();
            queue.offer(new Node(R, C, map[R][C]));
            int result = 0; // 정답
            while (!queue.isEmpty()) {
                int size = queue.size();

                if (L-- == 0) break;

                while (size-- > 0) {
                    Node node = queue.poll();
                    int y = node.y;
                    int x = node.x;
                    int type = node.type;

                    if (visited[y][x]) continue;

                    visited[y][x] = true;
                    result++;

                    boolean[] check = new boolean[4];
                    getType(check, type);

                    for (int i = 0; i < 4; i++) {
                        if (check[i]) {
                            int dy = y + directions[i][0];
                            int dx = x + directions[i][1];

                            if (dy >= 0 && dy < N && dx >= 0 && dx < M && !visited[dy][dx] && map[dy][dx] > 0) {
                                boolean[] temp = new boolean[4];
                                getType(temp, map[dy][dx]);

                                if (check[i] && temp[(i + 2) % 4]) {
                                    queue.offer(new Node(dy, dx, map[dy][dx]));
                                }
                            }
                        }
                    }
                }
            }

            sb.append("#").append(t + 1).append(" ");
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    private static void getType(boolean[] check, int type) {
        switch (type) {
            case 1:
                check[0] = check[1] = check[2] = check[3] = true;
                break;

            case 2:
                check[0] = check[2] = true;
                break;

            case 3:
                check[1] = check[3] = true;
                break;

            case 4:
                check[0] = check[1] = true;
                break;

            case 5:
                check[1] = check[2] = true;
                break;

            case 6:
                check[2] = check[3] = true;
                break;

            case 7:
                check[3] = check[0] = true;
                break;
        }
    }

}
