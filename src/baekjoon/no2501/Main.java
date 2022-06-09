package baekjoon.no2501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());    // 자연수
        int K = Integer.parseInt(tokenizer.nextToken());    // K번째로 작은 수

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N / 2; i++) {
            if (N % i == 0) { list.add(i); }
        }

        list.add(N);

        System.out.println(K <= list.size() ? list.get(K - 1) : "0");
    }

}
