package baekjoon.no9086;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());    // 테스트케이스 개수
        for (int t = 0; t < T; t++) {
            String target = reader.readLine();
            sb.append(target.charAt(0)).append(target.charAt(target.length() - 1)).append("\n");
        }

        System.out.println(sb);
    }

}
