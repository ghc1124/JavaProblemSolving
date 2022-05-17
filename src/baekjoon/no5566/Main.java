package baekjoon.no5566;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 단순 구현 문제
 * 2. 배열 탐색
 * 3. int 형으로 처리 가능
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());    // 칸 수
        int M = Integer.parseInt(tokenizer.nextToken());    // 주사위 던진 횟수

        int[] directive = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            directive[i] = Integer.parseInt(reader.readLine()); // 지시사항
        }

        int cnt = 1;
        int res = M;

        for (int i = 0; i < M; i++) {
            int curr = Integer.parseInt(reader.readLine());
            // System.out.println("들어온 값: " + curr);
            cnt += curr;

            // System.out.println("주사위 던진 후 값: " + cnt);

            if (cnt < N) {
                cnt += directive[cnt];
            }

            // System.out.println("지시사항 후 값: " + cnt);

            if (cnt >= N) {
                res = i + 1;
                break;
            }
        }

        System.out.println(res);
    }

}
