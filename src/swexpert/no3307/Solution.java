package swexpert.no3307;

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
            int N = Integer.parseInt(reader.readLine()); // 수열의 길이
            int[] num = new int[N];
            int[] DP = new int[N];

            int ans = 0;

            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < N; i++) {
                num[i] = Integer.parseInt(tokenizer.nextToken());
                for (int j = 0; j < i; j++) {
                    if (num[i] > num[j]) DP[i] = Math.max(DP[i], DP[j]);
                }

                DP[i]++;
                ans = Math.max(ans, DP[i]);
            }

            sb.append("#").append(t + 1).append(" ");
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }

}
