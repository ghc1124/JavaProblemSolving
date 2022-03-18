package swexpert.no1948;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine()); // 테케 개수

        int[] month = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; // 1-base index

        for (int i = 0; i < T; i++) {
            int result = 0;

            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int startMonth = Integer.parseInt(tokenizer.nextToken());
            int startDay = Integer.parseInt(tokenizer.nextToken());
            int endMonth = Integer.parseInt(tokenizer.nextToken());
            int endDay = Integer.parseInt(tokenizer.nextToken());

            if (startMonth == endMonth) result += endDay - startDay + 1;
            else {
                result += month[startMonth] - startDay + 1;

                for (int j = startMonth + 1; j < endMonth; j++) {
                    result += month[j];
                }

                result += endDay;
            }

            sb.append("#").append(i + 1).append(" ");
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

}
