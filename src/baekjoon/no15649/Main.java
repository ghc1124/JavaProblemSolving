package baekjoon.no15649;

import java.util.Scanner;

public class Main {

    private static StringBuilder result = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] nums = new int[N]; // 1 2 3
        boolean[] check = new boolean[N]; // false false false
        for (int i = 0; i < N; i++) {
            nums[i] = i + 1;
        }
        permutation(nums, check, 0, M, new StringBuilder());

        System.out.println(result);
    }

    private static void permutation(int[] nums, boolean[] check, int count, int M, StringBuilder sb) {
        if (count == M) {
            result.append(sb).append("\n");
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!check[i]) {
                check[i] = true; // 1을 뽑음
                sb.append(nums[i]).append(" ");
                permutation(nums, check, count + 1, M, sb);
                sb.setLength(sb.length() - 2);
                check[i] = false;
            }
        }
    }

}
