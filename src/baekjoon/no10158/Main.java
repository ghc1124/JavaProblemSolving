package baekjoon.no10158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int W = Integer.parseInt(tokenizer.nextToken()); // 열
        int H = Integer.parseInt(tokenizer.nextToken()); // 행
        tokenizer = new StringTokenizer(reader.readLine());
        int X = Integer.parseInt(tokenizer.nextToken()); // x 좌표
        int Y = Integer.parseInt(tokenizer.nextToken()); // y 좌표
        tokenizer = new StringTokenizer(reader.readLine());
        int T = Integer.parseInt(tokenizer.nextToken()); // 시간

        int resultX = (X + T) % (W * 2);
        int resultY = (Y + T) % (H * 2);

        if (resultX > W) resultX = W * 2 - resultX;
        if (resultY > H) resultY = H * 2 - resultY;

        System.out.println(resultX + " " + resultY);
    }

}
