package swexpert.no5643;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_DFS {

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
            for (int i = 1; i <= N; i++) {
                adjMatrix[i][0] = -1;
            }

            StringTokenizer tokenizer = null;
            int a, b;

            for (int i = 0; i < M; i++) {       // 간선 정보 입력받아 인접행렬에 표현
                tokenizer = new StringTokenizer(reader.readLine());
                a = Integer.parseInt(tokenizer.nextToken());
                b = Integer.parseInt(tokenizer.nextToken());
                adjMatrix[a][b] = 1;
            }

            for (int i = 1; i <= N; i++) {
                if (adjMatrix[i][0] == -1) {    // 아직 탐색을 안한 경우
                    dfs(i);
                }
            }

            // 자신보다 작은 학생수 카운트
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    adjMatrix[0][j] += adjMatrix[j][i];
                }
            }

            int answer = 0;
            for (int i = 1; i <= N; i++) {
                if (adjMatrix[i][0] + adjMatrix[0][i] == N - 1) answer++;
            }

            sb.append("#").append(tc + 1).append(" ");
            sb.append(answer);
        }

        System.out.println(sb);
    }

    private static void dfs(int cur) {          // 자신보다 큰놈들 따라감
        for (int i = 1; i <= N; i++) {
            if (adjMatrix[cur][i] != 0) {       // 나보다 큰 학생이면
                if (adjMatrix[i][0] == -1) {    // 아직 탐색 전이면
                    dfs(i);
                }
                // 탐색 종료 or 탐색이 이미 된 경우
                // 나보다 큰 학생이 알고있는 다른 학생과의 키 관계를 나와의 직접 관계로 업데이트
                if (adjMatrix[i][0] > 0) {      // i보다 큰 학생이 있다면
                    for (int j = 1; j <= N; j++) {
                        if (adjMatrix[i][j] == 1) {
                            adjMatrix[cur][i] = 1;
                        }
                    }
                }
            }
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            cnt += adjMatrix[cur][i];
        }
        adjMatrix[cur][0] = cnt;
    }

}
