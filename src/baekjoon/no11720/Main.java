package baekjoon.no11720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int result = 0;

        for (char c : reader.readLine().toCharArray()) {
            result += c - '0';
        }

        System.out.println(result);
    }

}
