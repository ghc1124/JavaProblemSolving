package baekjoon.no1158;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("<");
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        while (!queue.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                queue.offer(queue.poll());
            }
            sb.append(queue.poll()).append(", ");
        }
        sb.setLength(sb.length() - 2);
        System.out.println(sb.append(">"));

        scanner.close();
    }

}
