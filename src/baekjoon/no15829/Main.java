package baekjoon.no15829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        final int MOD = 1234567891;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(reader.readLine());    // 문자열의 길이
        long r = 1;
        long ans = 0L;

        char[] target = reader.readLine().toCharArray();
        for (int i = 0; i < L; i++) {
            ans += (target[i] - 'a' + 1) * r % MOD;
            r = r * 31 % MOD;
        }

        System.out.println(ans % MOD);
    }

}
