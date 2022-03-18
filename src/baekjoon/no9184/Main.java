package baekjoon.no9184;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int c = Integer.parseInt(tokenizer.nextToken());

            if (a == -1 && a == b && b == c) break;

            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ");
            sb.append(w(a, b, c)).append("\n");
        }

        System.out.println(sb);
    }

    private static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        String temp = "" + a + "/" + b + "/" + c;

        if (map.containsKey(temp)) return map.get(temp); // 이미 알고 있는 값인 경우

        if (a > 20 || b > 20 || c > 20) {
            map.put(temp, w(20, 20, 20));
            return map.get(temp);
        }

        if (a < b && b < c) {
            map.put(temp, w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c));
            return map.get(temp);
        }

        map.put(temp, w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1));
        return map.get(temp);
    }

}
