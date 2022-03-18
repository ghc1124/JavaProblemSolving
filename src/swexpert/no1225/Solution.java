package swexpert.no1225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            int T = Integer.parseInt(reader.readLine());
            Queue<Integer> queue = new ArrayDeque<>();
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            while (tokenizer.hasMoreTokens()) {
                queue.offer(Integer.parseInt(tokenizer.nextToken()));
            }
            queue = generateCode(queue);
            sb.append("#").append(T).append(" ");
            for (int num : queue) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static Queue generateCode(Queue<Integer> queue) {
        int minus = 0;

        while (true) {
            int temp = queue.poll();
            int target = temp - (minus++ % 5 + 1);
            if (target <= 0) {
                queue.offer(0);
                break;
            }
            queue.offer(target);
        }

        return queue;
    }

}
