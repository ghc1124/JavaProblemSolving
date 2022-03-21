package baekjoon.no7568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static class Person {

        int weight;
        int height;

        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }

        public boolean isBig(Person person) {
            return (this.weight > person.weight && this.height > person.height);
        }

    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine()); // 전체 사람의 수

        Person[] people = new Person[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            people[i] = new Person(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
        }

        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (people[j].isBig(people[i])) cnt++;
            }

            sb.append(cnt + 1).append(" ");
        }

        System.out.println(sb);
    }

}
