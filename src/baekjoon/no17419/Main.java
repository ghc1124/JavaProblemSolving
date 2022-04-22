package baekjoon.no17419;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        String temp = reader.readLine();

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            if (temp.charAt(i) == '1') cnt++;
        }

        System.out.println(cnt);
    }

}
