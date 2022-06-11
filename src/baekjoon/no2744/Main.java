package baekjoon.no2744;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[] target = reader.readLine().toCharArray();
        char[] res = new char[target.length];

        for (int i = 0; i < target.length; i++) {
            if (target[i] >= 'a' && target[i] <= 'z') {
                // 소문자인 경우
                res[i] = (char) (target[i] - 'a' + 'A');
            } else {
                res[i] = (char) (target[i] - 'A' + 'a');
            }
        }

        System.out.println(String.valueOf(res));
    }

}
