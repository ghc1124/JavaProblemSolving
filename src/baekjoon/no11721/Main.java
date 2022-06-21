package baekjoon.no11721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String target = reader.readLine();
        int length = target.length();

        for (int i = 0; i < length; i += 10) {
            if (i + 10 <= length) {
                sb.append(target, i, i + 10).append("\n");
            } else {
                sb.append(target.substring(i));
            }
        }

        System.out.println(sb);
    }

}
