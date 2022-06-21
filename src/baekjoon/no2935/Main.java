package baekjoon.no2935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String A = reader.readLine();
        String operator = reader.readLine();
        String B = reader.readLine();

        if (operator.equals("+")) {
            // 덧셈인 경우 이진수 OR 연산
            if (A.length() > B.length()) {
                System.out.println(A.substring(0, A.length() - B.length()) + B);
            } else if (B.length() > A.length()) {
                System.out.println(B.substring(0, B.length() - A.length()) + A);
            } else {
                System.out.println("2" + A.substring(1));
            }
        } else {
            // 곱셈인 경우 0의 갯수 합산
            System.out.println(A + B.substring(1));
        }
    }

}
