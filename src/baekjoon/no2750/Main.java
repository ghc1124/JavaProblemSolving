package baekjoon.no2750;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        int[] num = new int[N];

        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(reader.readLine());
        }

        Arrays.sort(num);

        for (int i = 0; i < N; i++) {
            sb.append(num[i]).append("\n");
        }

        System.out.println(sb);
    }

}
