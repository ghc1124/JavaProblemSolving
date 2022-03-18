package baekjoon.no2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        Stack<Tower> stack = new Stack<>(); // 탑의 인덱스와 층을 객체로 관리(Tower)

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(tokenizer.nextToken()); // 하나씩 입력받아 처리

            // 해당 레이저를 받아줄 탑이 나올 때까지 스택 pop 수행
            while (!stack.isEmpty()) {
                if (stack.peek().height > temp) {
                     // 해당 레이저를 받아줄 탑이 존재하면 그 탑의 인덱스를 출력
                    sb.append(stack.peek().index).append(" ");
                    break;
                } else {
                    // 없으면 pop
                    stack.pop();
                }
            }

            // 스택이 비었을 경우, 해당 레이저를 받아줄 탑이 없으므로 0을 추가
            if (stack.isEmpty()) {
                sb.append(0).append(" ");
            }

            stack.push(new Tower(i + 1, temp));
        }
        System.out.println(sb);
    }

}

class Tower {

    int index;
    int height;

    public Tower(int index, int height) {
        this.index = index;
        this.height = height;
    }

}