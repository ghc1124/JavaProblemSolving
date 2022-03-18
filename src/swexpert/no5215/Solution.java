package swexpert.no5215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    private static int T, N, L, ingredients[], calories[];
    private static int result;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(reader.readLine());
        int problemNum = 1;

        while (T-- > 0) {
            result = 0;
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            N = Integer.parseInt(tokenizer.nextToken());
            L = Integer.parseInt(tokenizer.nextToken());

            ingredients = new int[N];
            calories = new int[N];
            int count = N;
            int index = 0;

            while (count-- > 0) {
                tokenizer = new StringTokenizer(reader.readLine());
                ingredients[index] = Integer.parseInt(tokenizer.nextToken());
                calories[index++] = Integer.parseInt(tokenizer.nextToken());
            }

            combination(0, 0, 0);

            sb.append("#").append(problemNum++).append(" ");
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    private static void combination(int start, int calorie, int ingredient) {
        if (calorie > L) return;
        if (ingredient > result) result = ingredient;

        for (int i = start; i < N; i++) {
            combination(i + 1, calorie + calories[i], ingredient + ingredients[i]);
        }
    }

}
