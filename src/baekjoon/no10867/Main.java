package baekjoon.no10867;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        while (tokenizer.hasMoreTokens()) {
            queue.offer(Integer.parseInt(tokenizer.nextToken()));
        }

        int target = queue.poll();

        sb.append(target).append(" ");

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            if (target == temp) continue;

            sb.append(temp).append(" ");
            target = temp;
        }

        System.out.println(sb);
    }

}
