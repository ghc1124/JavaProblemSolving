package baekjoon.no1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int countZero, countOne;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(reader.readLine());
            int[] fibo = new int[N + 1];
            int[][] counts = new int[N + 1][2];
            countZero = 0;
            countOne = 0;

            fibonacci(counts, fibo, N);
            sb.append(countZero).append(" ").append(countOne).append("\n");
        }

        System.out.println(sb);
    }

    private static int fibonacci(int[][] counts, int[] nums, int n) {
        if (n == 0) {
            counts[n][0] = 1;
            countZero += counts[n][0];
            return 0;
        }

        if (n == 1) {
            counts[n][1] = 1;
            countOne += counts[n][1];
            return 1;
        }

        if (nums[n] != 0) {
            // n == 2부터
            counts[n][0] = counts[n - 1][0] + counts[n - 2][0];
            counts[n][1] = counts[n - 1][1] + counts[n - 2][1];
            countZero += counts[n][0];
            countOne += counts[n][1];
            return nums[n];
        }

        // 이게 메모이제이션!
        nums[n] = fibonacci(counts, nums, n - 1) + fibonacci(counts, nums, n - 2);

        return nums[n];
    }

}