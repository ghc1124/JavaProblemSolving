package swexpert.no5643;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_Floyd {

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

            /**
             * 플로이드 워셜 알고리즘 - 모든 쌍의 관계를 파악
             */

            for (int k = 1; k <= N; k++) {          // 경유 학생
                for (int i = 1; i <= N; i++) {      // 관계를 알고 싶은 학생
                    if (i == k || adjMatrix[i][k] == 0) continue;           // 경유하는 효과가 없기 때문에 건너뛰기
                    for (int j = 1; j <= N; j++) {  // 도착 학생(다른 학생)
                        if (adjMatrix[i][j] == 1) continue;
                        if (adjMatrix[k][j] == 1) adjMatrix[i][j] = 1;
                    }
                }
            }

            // 알 수 있는 모든 쌍의 관계가 반영되어 있음
            // 자신보다 작은 학생수 카운트
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    adjMatrix[i][0] += adjMatrix[i][j];
                    adjMatrix[0][j] += adjMatrix[i][j];
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

}
