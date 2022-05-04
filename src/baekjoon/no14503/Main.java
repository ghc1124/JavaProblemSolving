package baekjoon.no14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 }, };

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());    // 세로(행)
        int M = Integer.parseInt(tokenizer.nextToken());    // 가로(열)

        tokenizer = new StringTokenizer(reader.readLine());

        int r = Integer.parseInt(tokenizer.nextToken());    // 청소기 위치(행)
        int c = Integer.parseInt(tokenizer.nextToken());    // 청소기 위치(열)
        int currDir = Integer.parseInt(tokenizer.nextToken());  // 처음 방향

        int[][] arr = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        int ans = 0;

        Outer: while (true) {
            // 일단 청소
            if (!visited[r][c]) {
                ans++;
                visited[r][c] = true;
            }

            // 일단 3번 돌려보고 이 안에 빈칸이 있으면 전진한다.
            // 0이면 이동 가능, 1이면 불가
            for (int i = 1; i <= 4; i++) {
                int temp = currDir - i;
                if (temp < 0) temp += 4;
                int dy = r + directions[temp][0];
                int dx = c + directions[temp][1];

                if (dy >= 0 && dy < N && dx >= 0 && dx < M) {
                    if (arr[dy][dx] == 0 && !visited[dy][dx]) { // 빈 공간을 찾은 경우
                        r = dy;
                        c = dx; // 전진 처리
                        currDir = temp;
                        continue Outer;
                    }
                }
            }

            // 더 이상 갈 곳이 없는 경우
            int dy = r - directions[currDir][0];
            int dx = c - directions[currDir][1];

            if (dy >= 0 && dy < N && dx >= 0 && dx < M) {
                if (arr[dy][dx] == 0) { // 뒤가 빈칸인 경우 뒤로 한칸 이동
                    r = dy;
                    c = dx;
                } else {
                    break;
                }
            }
        }

        System.out.println(ans);
    }

}
