package baekjoon.no1946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static class Person {

        int paper;
        int interview;

        public Person(int paper, int interview) {
            this.paper = paper;
            this.interview = interview;
        }

    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine()); // 테스트케이스 개수

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(reader.readLine()); // 지원자 수
            Person[] people = new Person[N];
            StringTokenizer tokenizer = null;
            for (int i = 0; i < N; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                int paper = Integer.parseInt(tokenizer.nextToken());
                int interview = Integer.parseInt(tokenizer.nextToken());
                people[i] = new Person(paper, interview);
            }

            Arrays.sort(people, Comparator.comparingInt(o -> o.paper));

            int cnt = 0;
            int curr = people[0].interview;

            for (int i = 1; i < N; i++) {
                if (people[i].interview > curr) cnt++;
                else curr = people[i].interview;
            }

            sb.append(N - cnt).append("\n");
        }

        System.out.println(sb);
    }

}
