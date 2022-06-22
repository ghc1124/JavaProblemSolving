package baekjoon.no1495;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());    // 곡의 개수
        int S = Integer.parseInt(tokenizer.nextToken());    // 시작 볼륨
        int M = Integer.parseInt(tokenizer.nextToken());    // 최대 볼륨(0 ~ M)

        int[] vol = new int[N + 1];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 1; i <= N; i++) {
            vol[i] = Integer.parseInt(tokenizer.nextToken());
        }

        boolean[][] DP = new boolean[N + 1][M + 1]; // M까지 써야된다.
        DP[0][S] = true;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                if (!DP[i - 1][j]) continue;

                if (j + vol[i] <= M) DP[i][j + vol[i]] = true;

                if (j - vol[i] >= 0) DP[i][j - vol[i]] = true;
            }
        }

        int ans = -1;

        for (int i = M; i >= 0; i--) {
            if (DP[N][i]) {
                ans = i;
                break;
            }
        }

        System.out.println(ans);
    }

}
