package swexpert.no1228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            int originalLength = Integer.parseInt(reader.readLine()); // 원본 암호문 길이
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine()); // 원본 암호문
            ArrayDeque<String> deque = new ArrayDeque<>();
            while (tokenizer.hasMoreTokens()) {
                deque.offer(tokenizer.nextToken());
            }
            int commandLength = Integer.parseInt(reader.readLine()); // 명령어의 개수
            tokenizer = new StringTokenizer(reader.readLine()); // 명령어
            Queue<String> queue = new ArrayDeque<>();
            while (tokenizer.hasMoreTokens()) {
                queue.offer(tokenizer.nextToken());
            }

            deque = process(deque, queue);
            sb.append("#").append(i + 1).append(" ");
            for (int j = 0; j < 10; j++) {
                sb.append(deque.poll()).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static ArrayDeque process(ArrayDeque<String> origin, Queue<String> command) {
        while (!command.isEmpty()) {
            if (command.poll().equals("I")) {
                int index = Integer.parseInt(command.poll()); // 인덱스
                int count = Integer.parseInt(command.poll()); // 개수
                Stack<String> temp = new Stack<>(); // 임시 저장 스택
                for (int i = 0; i < index; i++) { // 저장할 위치까지 뺌
                    temp.push(origin.poll());
                }

                for (int i = 0; i < count; i++) {
                    temp.push(command.poll()); // 임시 저장 스택에다가 저장해둠
                }

                while (!temp.isEmpty()) { // 다시 붙이기
                    origin.offerFirst(temp.pop());
                }
            }
        }

        return origin;
    }

}
