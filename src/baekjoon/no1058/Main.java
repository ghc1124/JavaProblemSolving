package baekjoon.no1058;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());    // 사람의 수
        int[][] dist = new int[N][N];
        char[] arr = null;
        for (int i = 0; i < N; i++) {
            arr = reader.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if (arr[j] == 'Y') {
                    dist[i][j] = 1;
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int temp = dist[i][k] + dist[k][j]; // 오버플로우 조심!
                    if (temp >= 0 && dist[i][j] > temp) {
                        dist[i][j] = temp;
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (dist[i][j] <= 2) cnt++;
            }

            if (ans < cnt) ans = cnt;
        }

        System.out.println(ans);
    }

}
