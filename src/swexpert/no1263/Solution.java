package swexpert.no1263;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

            int N = Integer.parseInt(tokenizer.nextToken());
            int[][] adjMatrix = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    adjMatrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                    if (i != j && adjMatrix[i][j] == 0) adjMatrix[i][j] = 2000;
                }
            }

            for (int k = 0; k < N; k++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k] + adjMatrix[k][j]);
                    }
                }
            }

            int ans = 2000;

            for (int i = 0; i < N; i++) {
                int temp = 0;
                for (int j = 0; j < N; j++) {
                    temp += adjMatrix[i][j];
                }
                if (ans > temp) ans = temp;
            }

            sb.append("#").append(t + 1).append(" ");
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }

}
