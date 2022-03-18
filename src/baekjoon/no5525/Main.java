package baekjoon.no5525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("IO");
        }
        sb.append("I");

        int size = sb.length();

        int M = Integer.parseInt(reader.readLine());
        StringBuilder target = new StringBuilder(reader.readLine());
        char[] arr = target.toString().toCharArray();

        int result = 0;

        for (int i = 0; i < M - size;) {
            if (arr[i] == 'I') {
                if ((target.substring(i, i + size)).equals(sb.toString())) {
                    result++;
                    i += 2;
                    continue;
                }
            }

            i++;
        }

        System.out.println(result);
    }

}
