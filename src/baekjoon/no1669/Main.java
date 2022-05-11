package baekjoon.no1669;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int X = Integer.parseInt(tokenizer.nextToken());    // 원숭이
        int Y = Integer.parseInt(tokenizer.nextToken());    // 멍멍이

        int target = Math.abs(X - Y);

        if (target < 3) {
            System.out.println(target);
            return;
        }

        int day = 2;
        int height = 1;
        target -= 2;

        while (target > 0) {
            if (target <= (height + 1) * 2) {
                // 이제 끝
                if (target <= (height + 1)) {
                    day++;
                } else {
                    day += 2;
                }
                break;
            } else {
                target -= (height + 1) * 2;
                day += 2;
                height++;
            }
        }

        System.out.println(day);
    }

}
