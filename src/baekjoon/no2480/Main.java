package baekjoon.no2480;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int x = Integer.parseInt(tokenizer.nextToken());
        int y = Integer.parseInt(tokenizer.nextToken());
        int z = Integer.parseInt(tokenizer.nextToken());

        int res = 0;

        if (x == y && y == z) {
            // 셋 다 같은 경우
            res = 10000 + x * 1000;
        } else if (x == y || y == z || x == z) {
            // 둘만 같은 경우
            if (x == y) {
                res = 1000 + x * 100;
            } else if (y == z) {
                res = 1000 + y * 100;
            } else {
                res = 1000 + z * 100;
            }
        } else {
            res = Math.max(Math.max(x, y), z) * 100;
        }

        System.out.println(res);
    }

}
