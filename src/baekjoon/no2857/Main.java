package baekjoon.no2857;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            if (reader.readLine().contains("FBI")) {
                sb.append(i + 1).append(" ");
            }
        }

        if (sb.length() == 0) sb.append("HE GOT AWAY!");

        System.out.println(sb);
    }

}
