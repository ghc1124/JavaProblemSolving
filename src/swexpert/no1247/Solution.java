package swexpert.no1247;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    private static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine()); // 테케 갯수

        StringBuilder sb = new StringBuilder();
        int problemNum = 1;

        while (T-- > 0) {
            int N = Integer.parseInt(reader.readLine()); // 고객의 수
            int[][] value = new int[N + 2][2];
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < N + 2; i++) {
                for (int j = 0; j < 2; j++) {
                    value[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            min = Integer.MAX_VALUE;

            int[] index = new int[N];
            for (int i = 0; i < N; i++) {
                index[i] = i + 2;
            }

            // 순열로 풀어보자
            permutation(index, new int[N], 0, 0, value);

            sb.append("#").append(problemNum++).append(" ");
            sb.append(min).append("\n");
        }

        System.out.println(sb);
    }

    private static void permutation(int[] index, int[] ans, int flag, int cnt, int[][] value) {
        if (cnt == index.length) {
            // 배열 완성

            // 출발은 회사
            // 도착은 집
            int sum = 0;

            // 회사에서 첫 번째 고객까지의 거리
            sum += Math.abs(value[ans[0]][0] - value[1][0]) + Math.abs(value[ans[0]][1] - value[1][1]);

            for (int i = 1; i < ans.length; i++) {
                sum += Math.abs(value[ans[i]][0] - value[ans[i - 1]][0]) + Math.abs(value[ans[i]][1] - value[ans[i - 1]][1]);
                if (sum > min) return;
            }

            // 마지막 고객에서 집까지의 거리
            sum += Math.abs(value[ans[ans.length - 1]][0] - value[0][0]) + Math.abs(value[ans[ans.length - 1]][1] - value[0][1]);

            min = Math.min(min, sum);

            return;
        }

        for (int i = 0; i < index.length; i++) {
            if ((flag & 1 << i) == 0) {
                ans[cnt] = index[i];
                permutation(index, ans, flag | 1 << i, cnt + 1, value);
            }
        }
    }

}