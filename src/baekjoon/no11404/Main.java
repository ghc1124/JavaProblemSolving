package baekjoon.no11404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 플로이드 워셜
 * 2. 시간복잡도 -> 정점^3
 * 3. 변수 -> 뭔가 int로 가능할 것 같음
 * 4. 특이사항 -> 시작 도시와 도착 도시를 연결하는 노선은 하나가 아닐 수 있음
 */

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());    // 도시의 개수
        int m = Integer.parseInt(reader.readLine());    // 버스의 개수

        StringTokenizer tokenizer = null;

        int[][] city = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(city[i], Integer.MAX_VALUE);
            city[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());

            int from = Integer.parseInt(tokenizer.nextToken());
            int to = Integer.parseInt(tokenizer.nextToken());
            int weight = Integer.parseInt(tokenizer.nextToken());

            city[from][to] = Math.min(city[from][to], weight);
        }

        // i에서 j로 가는데 "k를 거쳐서" 간다!
        for (int k = 0; k <= n; k++) {
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= n; j++) {
                    int temp = city[i][k] + city[k][j];
                    if (temp >= 0 && city[i][j] > temp) {
                        city[i][j] = temp;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sb.append(city[i][j] == Integer.MAX_VALUE ? 0 : city[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

}
