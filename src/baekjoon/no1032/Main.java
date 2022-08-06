package baekjoon.no1032;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());    // 파일 이름의 개수

        StringBuilder sb = new StringBuilder(reader.readLine());
        char[] target = sb.toString().toCharArray();

        for (int i = 0; i < N - 1; i++) {
            char[] temp = reader.readLine().toCharArray();

            for (int j = 0; j < target.length; j++) {
                if (target[j] != temp[j]) {
                    sb.replace(j, j + 1, "?");
                }
            }
        }

        System.out.println(sb);
    }

}
