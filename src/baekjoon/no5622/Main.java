package baekjoon.no5622;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] target = reader.readLine().toCharArray();
        int result = 0;
        for (char c : target) {
            if (c >= 'W') {
                result += 10;
            } else if (c >= 'T') {
                result += 9;
            } else if (c >= 'P') {
                result += 8;
            } else if (c >= 'M') {
                result += 7;
            } else if (c >= 'J') {
                result += 6;
            } else if (c >= 'G') {
                result += 5;
            } else if (c >= 'D') {
                result += 4;
            } else if (c >= 'A') {
                result += 3;
            }
        }
        System.out.println(result);
    }

}
