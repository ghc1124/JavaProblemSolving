package baekjoon.no2908;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int num1 = Integer.parseInt(tokenizer.nextToken());
        int num2 = Integer.parseInt(tokenizer.nextToken());

        System.out.println(Math.max(calc(num1), calc(num2)));
    }

    private static int calc(int num) {
        int result = 0;
        int multiple = 100;

        while (num > 0) {
            result += num % 10 * multiple;
            num /= 10;
            multiple /= 10;
        }
        return result;
    }

}
