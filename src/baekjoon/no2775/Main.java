package baekjoon.no2775;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());

        while (T-- > 0) {
            int k = Integer.parseInt(reader.readLine());
            int n = Integer.parseInt(reader.readLine());
            int[][] apt = new int[k + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                apt[0][i] = i;
            }

            for (int i = 1; i <= k; i++) {
                apt[i][1] = 1;
            }

            for (int i = 1; i <= k; i++) {
                for (int j = 2; j <= n; j++) {
                    apt[i][j] = apt[i][j - 1] + apt[i - 1][j];
                }
            }

            sb.append(apt[k][n]).append("\n");
        }

        System.out.println(sb);
    }

}
