package baekjoon.no2902;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String target = reader.readLine();
        for (char c : target.toCharArray()) {
            if (c <= 'Z' && c >= 'A') sb.append(c);
        }

        System.out.println(sb);
    }

}
