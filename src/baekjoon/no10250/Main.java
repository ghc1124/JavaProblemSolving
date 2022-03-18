package baekjoon.no10250;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        while (T-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int H = Integer.parseInt(tokenizer.nextToken());
            int W = Integer.parseInt(tokenizer.nextToken());
            int N = Integer.parseInt(tokenizer.nextToken());

            int floor = N % H == 0 ? H : N % H;
            int room = (N - 1) / H + 1;
            sb.append(floor * 100 + room).append("\n");
        }

        System.out.println(sb);
    }

}
