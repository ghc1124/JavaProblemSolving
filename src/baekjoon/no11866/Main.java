package baekjoon.no11866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            queue.offer(i + 1);
        }

        sb.append("<");

        int cnt = 1;
        while (!queue.isEmpty()) {
            if (cnt++ % K == 0) {
                sb.append(queue.poll()).append(", ");
            } else {
                queue.offer(queue.poll());
            }
        }

        sb.setLength(sb.length() - 2);

        System.out.println(sb.append(">"));
    }

}
