package swexpert.no5607;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());    // 테스트케이스

        long[] factorial = new long[1000001];
        factorial[0] = 1;
        for (int i = 1; i <= 1000000; i++) {
            factorial[i] = factorial[i - 1] * i % 1234567891;
        }

        for (int t = 0; t < T; t++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

            int N = Integer.parseInt(tokenizer.nextToken());
            int R = Integer.parseInt(tokenizer.nextToken());

            long res = (factorial[N] * pow((factorial[R] * factorial[N - R]) % 1234567891, 1234567891 - 2)) % 1234567891;

            sb.append("#").append(t + 1).append(" ");
            sb.append(res).append("\n");
        }

        System.out.println(sb);
    }

    // 분할정복
    private static long pow(long a, long b) {
        if (b == 0) return 1;

        long ans = pow(a, b / 2);
        long next = ans * ans % 1234567891;

        if (b % 2 == 0) return next;
        else return next * a % 1234567891;
    }

}
