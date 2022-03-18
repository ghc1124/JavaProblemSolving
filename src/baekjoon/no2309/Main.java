package baekjoon.no2309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] heights = new int[9];

        for (int i = 0; i < heights.length; i++) {
            heights[i] = Integer.parseInt(reader.readLine());
        }

        Arrays.sort(heights);
        find(heights, new int[7], 0, 0, 0);

        System.out.println(sb);
    }

    // 조합!
    private static void find(int[] heights, int[] answer, int count, int sum, int start) {
        if (sum > 100) return;
        if (count == 7) {
            if (sum == 100) {
                sb.setLength(0);
                for (int n : answer) {
                    sb.append(n).append("\n");
                }
            }
            return;
        }

        for (int i = start; i < heights.length; i++) {
            sum += heights[i];
            answer[count] = heights[i];
            find(heights, answer, count + 1, sum, i + 1);
            sum -= heights[i];
        }
    }

}
