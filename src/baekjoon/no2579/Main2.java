package baekjoon.no2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine()); // 계단의 수

        int[] nums = new int[N]; // 배열 초기화
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(reader.readLine());
        }

        int[] max = new int[N];
        max[0] = nums[0];
        if (N > 1) {
            max[1] = nums[1] + nums[0];

            if (N > 2) {
                max[2] = Math.max(nums[0], nums[1]) + nums[2];

                for (int i = 3; i < N; i++) {
                    max[i] = Math.max(max[i - 3] + nums[i - 1], max[i - 2]) + nums[i];
                }
            }
        }

        System.out.println(max[N - 1]);
    }

}
