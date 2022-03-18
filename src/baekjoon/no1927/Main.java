package baekjoon.no1927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 최소 힙

        int N = Integer.parseInt(reader.readLine()); // 연산의 개수

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(reader.readLine());

            if (temp == 0) {
                if (pq.isEmpty()) sb.append(0);
                else sb.append(pq.poll());
                sb.append("\n");
            } else {
                pq.offer(temp);
            }
        }

        System.out.println(sb);
    }

}
