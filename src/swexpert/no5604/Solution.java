package swexpert.no5604;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    private static long[] cnt;  // 0 ~ 9까지 등장 횟수

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());    // 테스트케이스 개수

        for (int t = 0; t < T; t++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            long A = Long.parseLong(tokenizer.nextToken());
            long B = Long.parseLong(tokenizer.nextToken());

            cnt = new long[10];
            long n = 1;
            // 남는 부분 먼저 처리
            while (A <= B) {
                // 처음 부분. A를 증가시키면서 위의 남는 부분을 처리한다.
                for (; A % 10 != 0 && A <= B; A++) {
                    parse(A, n);
                }

                // 위쪽 부분 처리
                for(; B % 10 != 9 && A <= B; B--) {
                    parse(B, n);
                }

                if (A > B) break;

                // row의 개수만큼 추가
                A /= 10;
                B /= 10;
                long rowCnt = B - A + 1;
                for (int i = 0; i < 10; i++) {
                    cnt[i] += rowCnt * n;
                }

                n *= 10;
            }

            long sum = 0;
            for (int i = 1; i < 10; i++) {
                sum += i * cnt[i];
            }

            sb.append("#").append(t + 1).append(" ");
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }

    // 자릿수 나누기
    private static void parse(long x, long n) {
        // 123 -> 3, 2, 1
        while (x > 0) {
            cnt[(int) (x % 10)] += n;
            x /= 10;
        }
    }

}
