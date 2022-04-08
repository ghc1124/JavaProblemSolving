package baekjoon.no17135;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N, M, D, enemyCnt, res;
    private static int[][] map, directions = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };  // 왼쪽 우선

    private static class Node {

        int y;          // 행
        int x;          // 열
        int distance;   // 거리

        public Node(int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());    // 행
        M = Integer.parseInt(tokenizer.nextToken());    // 열
        D = Integer.parseInt(tokenizer.nextToken());    // 궁수의 공격 거리 제한

        map = new int[N + 1][M];                    // 성의 위치까지 고려하여 행을 +1 해준다.
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
                if (map[i][j] == 1) enemyCnt++;
            }
        }

        combination(new int[3], 0, 0);

        System.out.println(res);
    }

    private static void combination(int[] target, int start, int cnt) {
        if (cnt == 3) {
            int removeCnt = 0;
            int totalCnt = enemyCnt;

            int[][] arr = new int[N + 1][M];

            for (int i = 0; i <= N; i++) {
                arr[i] = map[i].clone();
            }

            while (totalCnt != 0) {
                List<Node> removeList = new ArrayList<>();

                // 궁수 3명 배치
                // 가장 가까운 적 찾기(단, 궁수들이 같은 적을 타겟으로 삼을 수도 있음)
                // bfs
                for (int i = 0; i < 3; i++) {
                    Node temp;
                    if ((temp = bfs(new Node(N, target[i], 0), arr)) != null) {
                        // 적을 잡은 경우
                        removeList.add(temp);
                    }
                }

                // 적 제거 처리
                for (Node node : removeList) {
                    if (arr[node.y][node.x] == 1) {
                        arr[node.y][node.x] = 0;
                        removeCnt++;
                        totalCnt--;
                    }
                }

                // 적들의 진격
                int[][] temp = new int[N + 1][M];
                for (int i = 1; i < N; i++) {
                    temp[i] = arr[i - 1].clone();
                }

                int sum = 0;

                for (int i = 0; i < M; i++) {
                    sum += arr[N - 1][i];
                }

                totalCnt -= sum;

                arr = temp;
            }

            res = Math.max(res, removeCnt);

            return;
        }

        for (int i = start; i < M; i++) {
            target[cnt] = i;
            combination(target, i + 1, cnt + 1);
        }
    }

    private static Node bfs(Node start, int[][] arr) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(start);

        boolean[][] visited = new boolean[N + 1][M];

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            int y = curr.y;
            int x = curr.x;
            int dist = curr.distance;

            if (visited[y][x]) continue;
            if (dist <= D && arr[y][x] == 1) return curr;
            if (dist > D) return null;

            visited[y][x] = true;

            for (int i = 0; i < 4; i++) {
                int dy = y + directions[i][0];
                int dx = x + directions[i][1];

                if (dy >= 0 && dy < N && dx >= 0 && dx < M) {
                    if (!visited[dy][dx]) {
                        queue.offer(new Node(dy, dx, dist + 1));
                    }
                }
            }
        }

        return null;
    }

}
