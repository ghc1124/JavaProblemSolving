package baekjoon.no16637;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    private static int res = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());    // 수식의 길이
        StringBuilder sb = new StringBuilder(reader.readLine());

        subset(new StringBuilder(sb), 0);

        System.out.println(res);
    }

    private static void subset(StringBuilder sb, int idx) {
        if (idx >= sb.length() - 1) {
            Stack<String> stack = new Stack<>();

            // sb는 한 자리 정수가 보장된다.
            for (int i = 0; i < sb.length();) {
                char c = sb.charAt(i);
                if (c == '(') {
                    int temp = process(sb.substring(i + 1, i + 4));
                    if (!stack.isEmpty()) {
                        calc(stack, temp);
                    } else {
                        stack.push(temp + "");
                    }

                    i += 5;
                } else if (c == '+' || c == '-' || c == '*') {
                    stack.push(Character.toString(c));
                    i++;
                } else {    // 숫자의 경우
                    if (!stack.isEmpty()) {
                        calc(stack, c - '0');
                    } else {
                        stack.push(Character.toString(c));
                    }
                    i++;
                }
            }

            res = Math.max(res, Integer.parseInt(stack.pop()));

            return;
        }

        StringBuilder temp = new StringBuilder(sb);
        sb.insert(idx, "(").insert(idx + 4, ")");
        subset(sb, idx + 6);
        subset(temp, idx + 2);
    }

    private static void calc(Stack<String> stack, int num) {
        String temp = stack.peek();
        if (temp.equals("*") || temp.equals("+") || temp.equals("-")) {
            // 꺼내서 계산
            int b = num;
            String operator = stack.pop();
            int a = Integer.parseInt(stack.pop());

            switch (operator) {
                case "+": stack.push(a + b + ""); break;
                case "-": stack.push(a - b + ""); break;
                case "*": stack.push(a * b + ""); break;
            }
        }
    }

    private static int process(String sub) {
        int a = sub.charAt(0) - '0';
        int b = sub.charAt(2) - '0';
        char operator = sub.charAt(1);
        switch (operator) {
            case '+': return a + b;
            case '-': return a - b;
            default: return a * b;
        }
    }

}
