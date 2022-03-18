package baekjoon.no2869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int A = Integer.parseInt(tokenizer.nextToken());
        int B = Integer.parseInt(tokenizer.nextToken());
        int V = Integer.parseInt(tokenizer.nextToken());

        // 하루의 이동거리 -> A - B
        int day = (V - B) / (A - B);

        if ((V - B) % (A - B) != 0) day++;

        System.out.println(day);
    }

}

