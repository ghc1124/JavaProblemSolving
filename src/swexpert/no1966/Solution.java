package swexpert.no1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine()); // 테캐 개수

        for (int x = 0; x < T; x++) {
            int N = Integer.parseInt(reader.readLine()); // 숫자 개수
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < N; i++) {
                pq.offer(Integer.parseInt(tokenizer.nextToken()));
            }

            sb.append("#").append(x + 1).append(" ");

            while (!pq.isEmpty()) sb.append(pq.poll()).append(" ");

            sb.append("\n");
        }

        System.out.println(sb);
    }

}
