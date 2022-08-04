package baekjoon.no9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());    // 입력 개수

        Stack<Character> stack = new Stack<>();    // 괄호를 담기 위한 스택
        StringBuilder sb = new StringBuilder();    // 결과를 저장하기 위한 StringBuilder

        for (int t = 0; t < T; t++) {
            // 입력 개수만큼 반복한다.
            stack.clear();  // 스택 초기화

            boolean flag = false;

            char[] input = reader.readLine().toCharArray(); // 입력을 저장할 문자 배열
            for (int i = 0; i < input.length; i++) {
                if (input[i] == '(') {
                    stack.push(input[i]);
                } else {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        sb.append("NO");
                        flag = true;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            if (!flag) {    // 정상적으로 반복문이 종료된 경우
                if (stack.isEmpty()) {
                    sb.append("YES");
                } else {
                    sb.append("NO");
                }
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

}
