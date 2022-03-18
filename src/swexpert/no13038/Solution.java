package swexpert.no13038;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        for (int t = 0; t < T; t++) {
            int D = Integer.parseInt(reader.readLine());
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

            int[] week = new int[7];
            for (int i = 0; i < 7; i++) {
                week[i] = Integer.parseInt(tokenizer.nextToken());
            }

            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 7; i++) {
                if (week[i] == 0) continue; // 수업이 열리지 않는 날은 패스

                int day = i, cnt = 0;
                while (true) {
                    if (week[day++ % 7] == 1) cnt++;

                    if (cnt == D) { // 머무른 최소일수
                        min = Math.min(min, day - i);
                        break;
                    }
                }
            }

            sb.append("#").append(t + 1).append(" ");
            sb.append(min).append("\n");
        }

        System.out.println(sb);
    }

}
