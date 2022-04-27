package baekjoon.no10971;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[][] adjMatrix, DP;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine()); // 도시의 수

        StringTokenizer tokenizer = null;

        adjMatrix = new int[N][N]; // 인접 행렬
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < N; j++) {
                adjMatrix[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        DP = new int[N][1 << N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 1 << N; j++) {
                DP[i][j] = Integer.MAX_VALUE;
            }
        }

        System.out.println(tsp(0, 1));
    }

    // city -> 현재 도시, visit -> 방문한 도시 리스트(이진수로 표시한다. 비트마스킹!!)
    private static int tsp(int city, int visit) {
        if (visit == (1 << N) - 1) {
            // 모든 도시를 방문한 경우(ex. 도시가 4개면 1111 -> 15(2^4 - 1)
            // 다시 돌아갈 수 있는지 확인한다.
            // 0번 정점을 시작점으로 정했으므로 0으로 갈 수 있는지 확인
            return adjMatrix[city][0] == 0 ? Integer.MAX_VALUE : adjMatrix[city][0];
        }

        if (DP[city][visit] != Integer.MAX_VALUE) {
            // 이미 방문한 노드인 경우 바로 리턴한다(메모이제이션!).
            return DP[city][visit];
        }

        // 모든 정점에 대해 진행한다. 즉, 완전탐색!
        // 아 어렵다...
        // 완전탐색 + DP + 비트마스킹 환장 파티...
        for (int i = 0; i < N; i++) {
            if ((visit & (1 << i)) == 0 && adjMatrix[city][i] != 0) {
                // 갈 수 있는 도시이고, 아직 방문하지 않은 도시일 때!!
                DP[city][visit] = Math.min(DP[city][visit], tsp(i, visit | (1 << i)) + adjMatrix[city][i]);
            }
        }

        return DP[city][visit];
    }

}
