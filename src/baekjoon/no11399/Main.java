package baekjoon.no11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] people = new int[N];
        int result = 0;
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(people);
        result += people[0];

        for (int i = 1; i < N; i++) {
            people[i] += people[i - 1];
            result += people[i];
        }

        System.out.println(result);
    }

}
