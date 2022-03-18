package baekjoon.no1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken()); // 듣도 못한 사람의 수
        int M = Integer.parseInt(tokenizer.nextToken()); // 보도 못한 사람의 수

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(reader.readLine());
        }

        int cnt = 0;

        TreeSet<String> treeSet = new TreeSet<>();
        for (int i = 0; i < M; i++) {
            String temp = reader.readLine();
            if (set.contains(temp)) {
                cnt++;
                treeSet.add(temp);
            }
        }

        for (String str : treeSet) {
            sb.append(str).append("\n");
        }

        System.out.println(cnt);
        System.out.println(sb);
    }

}
