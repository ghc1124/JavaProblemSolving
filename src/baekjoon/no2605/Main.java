package baekjoon.no2605;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        LinkedList<Integer> linkedList = new LinkedList<>();
        int studentNum = 1;
        linkedList.add(studentNum);
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        tokenizer.nextToken(); // 1번 학생은 고정적으로 0번
        while (--N > 0) {
            int current = Integer.parseInt(tokenizer.nextToken());
            int index = linkedList.size() - current;
            linkedList.add(index, ++studentNum);
        }

        for (int n : linkedList) {
            sb.append(n).append(" ");
        }

        System.out.println(sb);
    }

}
