package baekjoon.no14696;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int ROUND = Integer.parseInt(reader.readLine());

        for (int i = 0; i < ROUND; i++) {
            int[] cardA = new int[4]; // A의 카드 그림
            int[] cardB = new int[4]; // B의 카드 그림
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine()); // 각 라운드별 A의 선택
            int numA = Integer.parseInt(tokenizer.nextToken());
            for (int j = 0; j < numA; j++) {
                cardA[Integer.parseInt(tokenizer.nextToken()) - 1]++;
            }

            tokenizer = new StringTokenizer(reader.readLine()); // 각 라운드별 B의 선택
            int numB = Integer.parseInt(tokenizer.nextToken());
            for (int j = 0; j < numB; j++) {
                cardB[Integer.parseInt(tokenizer.nextToken()) - 1]++;
            }

            boolean flag = false;

            for (int j = 3; j >= 0; j--) {
                if (cardA[j] - cardB[j] != 0) { // 별의 갯수가 다름
                    sb.append(cardA[j] > cardB[j] ? "A" : "B");
                    flag = true;
                    break;
                }
            }

            if (!flag) sb.append("D");

            sb.append("\n");
        }

        System.out.println(sb);
    }

}
