package baekjoon.no21966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());    // 문자열의 길이

        String target = reader.readLine();

        if (target.length() <= 25) {
            System.out.println(target);
            return;
        }

        String temp = target.substring(11, target.length() - 11);
        if (!temp.matches(".*\\..*") || temp.matches("^[^.]*\\.$")) {
            // 중간에 마침표가 없거나, 문장의 마지막에만 마침표가 위치하는 경우
            System.out.println(target.substring(0, 11) + "..." + target.substring(target.length() - 11));
        } else {
            System.out.println(target.substring(0, 9) + "......" + target.substring(target.length() - 10));
        }
    }

}
