package baekjoon.no10808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[] target = reader.readLine().toCharArray();
        int[] cnt = new int[26];
        for (int i = 0; i < target.length; i++) {
            cnt[target[i] - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            sb.append(cnt[i]).append(" ");
        }

        System.out.println(sb);
    }

}
