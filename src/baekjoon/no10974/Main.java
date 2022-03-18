package baekjoon.no10974;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] nums = new int[N]; // 1 2 3
        boolean[] check = new boolean[N]; // false false false
        for (int i = 0; i < N; i++) {
            nums[i] = i + 1;
        }
        permutation(nums, check, N, new StringBuilder());

        System.out.println(result);
    }

    private static void permutation(int[] nums, boolean[] check, int count, StringBuilder sb) {
        if (count == 0) {
            result.append(sb).append("\n");
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!check[i]) {
                check[i] = true; // 1을 뽑음
                sb.append(nums[i]).append(" ");
                permutation(nums, check, count - 1, sb);
                sb.setLength(sb.length() - 2);
                check[i] = false;
            }
        }
    }

}
