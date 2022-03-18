package swexpert.no1223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int problemNum = 1;

        for (int i = 0; i < 10; i++) {
            StringBuilder sb = new StringBuilder();
            int size = Integer.parseInt(reader.readLine());
            char[] temp = reader.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();
            char operator = ' ';

            // 중위 표기법 -> 후위 표기법
            for (int j = 0; j < size; j++) {
                // + -> 43번, * -> 42번
                if (temp[j] == '+' || temp[j] == '*') {
                    if (!stack.isEmpty()) {
                        char prev = stack.peek();
                        if (prev == temp[j]) { // 같을 경우
                            sb.append(stack.pop());
                        } else if (prev < temp[j]) { // 이전이 '*', 새로 들어온게 '+'인 경우
                            while (!stack.isEmpty()) {
                                sb.append(stack.pop());
                            }
                        }
                    }
                    stack.push(temp[j]);
                } else {
                    sb.append(temp[j]);
                }
            }

            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }

            // 후위 표기법 계산
            Stack<Integer> calcStack = new Stack<>();
            for (char c : sb.toString().toCharArray()) {
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

            stringBuilder.append("#").append(problemNum++).append(" ");
            stringBuilder.append(calcStack.pop()).append("\n");
        }
        System.out.println(stringBuilder);
    }

}
