package swexpert.no8458;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());        // 테스트케이스

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(reader.readLine());    // 개수

            int max = 0, mod = 0, answer = -1;
            boolean flag = false;

            for (int i = 0; i < N; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                int x = Integer.parseInt(tokenizer.nextToken());
                int y = Integer.parseInt(tokenizer.nextToken());

                int temp = Math.abs(x) + Math.abs(y);

                max = Math.max(max, temp);

                if (i == 0) mod = temp % 2;  // 처음 값이 max에 들어갈 것이기 때문
                else if (temp % 2 != mod) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                int sum = 0;        // 움직이는 총 거리
                int distance = 0;   // 현재 거리
                answer = 0;

                while (true) {
                    if (sum == max || (sum > max && (sum - max) % 2 == 0)) break;
                    sum += ++distance;  // 총 거리가 최댓값을 벗어났다는 것은 원점을 지나쳤다는 것이므로 이 경우 짝수여야 왔다갔다 할 수 있음.
                    answer++;
                }
            }

            sb.append("#").append(t + 1).append(" ");
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

}
