package swexpert.no9229;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    private static int maxWeight;
    private static int result;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        int problemNum = 1;

        while (T-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int N = Integer.parseInt(tokenizer.nextToken()); // 과자 개수
            maxWeight = Integer.parseInt(tokenizer.nextToken()); // 무게 제한
            result = -1; // 기본값으로 초기화
            tokenizer = new StringTokenizer(reader.readLine());
            int[] snacks = new int[N];
            for (int i = 0; i < N; i++) {
                snacks[i] = Integer.parseInt(tokenizer.nextToken());
            }
            combination(snacks, 0, 0, 0);
            sb.append("#").append(problemNum++).append(" ");
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static void combination(int[] snacks, int weight, int count, int start) {
        if (count == 2) {
            if (weight <= maxWeight) result = Math.max(result, weight);
            return;
        }

        for (int i = start; i < snacks.length; i++) {
            weight += snacks[i];
            combination(snacks, weight, count + 1, i + 1);
            weight -= snacks[i];
        }
    }

}
