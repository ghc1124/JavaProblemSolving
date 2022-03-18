package swexpert.no1224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int problemNum = 1;

        for (int i = 0; i < 10; i++) {
            int size = Integer.parseInt(reader.readLine());
            StringBuilder tempString = new StringBuilder();
            Stack<String> temp = new Stack<>();
            // 중위 표기 -> 후위 표기
            for (String str : reader.readLine().split("")) {
                if (str.equals(")")) {
                    ArrayDeque<String> arrayDeque = new ArrayDeque<>();
                    StringBuilder tempString2 = new StringBuilder();
                    while (!temp.peek().equals("(")) {
                        arrayDeque.offer(temp.pop());
                    }
                    temp.pop();
                    arrayDeque = stackProcess(arrayDeque);
                    while (!arrayDeque.isEmpty()) {
                        tempString2.append(arrayDeque.poll());
                    }
                    temp.push(tempString2.toString());
                } else {
                    temp.push(str);
                }
            }

            tempString.setLength(0);

            while (!temp.isEmpty()) {
                tempString.append(temp.pop());
            }

            // 중위 표현 계산
            Stack<Integer> calcStack = new Stack<>();
            for (char c : tempString.toString().toCharArray()) {
                if (c == '+' || c == '*') {
                    int head = ' ';
                    int tail = ' ';

                    int result = 0;

                    if (!calcStack.isEmpty()) tail = calcStack.pop();
                    if (!calcStack.isEmpty()) head = calcStack.pop();

                    if (c == '+') result = head + tail;
                    else result = head * tail;

                    calcStack.push(result);
                } else {
                    calcStack.push(c - '0');
                }
            }

            sb.append("#").append(problemNum++).append(" ");
            sb.append(calcStack.pop()).append("\n");
        }

        System.out.println(sb);
    }

    private static ArrayDeque<String> stackProcess(ArrayDeque<String> arrayDeque) {
        ArrayDeque<String> deque = new ArrayDeque<>();
        Stack<String> stack = new Stack<>();

        String prev = "";

        while (!arrayDeque.isEmpty()) {
            String current = arrayDeque.pollLast();
            if (current.equals("*") || current.equals("+")) {
                if (!stack.isEmpty()) {
                    prev = stack.peek();
                    if (prev.equals(current)) {
                        deque.offer(stack.pop());
                    } else if (prev.equals("*")) { // * -> +
                        while (!stack.isEmpty()) {
                            deque.offer(stack.pop());
                        }
                    }
                }
                stack.push(current);
            } else {
                deque.offer(current);
            }
        }

        while (!stack.isEmpty()) {
            deque.offer(stack.pop());
        }

        return deque;
    }

}
