package baekjoon.no2525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int A = Integer.parseInt(tokenizer.nextToken());    // 시간
        int B = Integer.parseInt(tokenizer.nextToken());    // 분
        int C = Integer.parseInt(reader.readLine());    // 걸리는 시간

        int temp = B + C;
        int hour = A;
        int minute = temp % 60;

        if (temp >= 60) {
            hour += temp / 60;
            if (hour > 23) hour -= 24;
        }

        System.out.println(hour + " " + minute);
    }

}
