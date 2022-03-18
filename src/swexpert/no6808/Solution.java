package swexpert.no6808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    private static boolean[] isSelected = new boolean[9];
    private static int[] selected = new int[9];

    private static int win, lose;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        int problemNum = 1;

        while (T-- > 0) {
            win = 0;
            lose = 0;

            int[] temp = new int[19];
            for (int i = 1; i < 19; i++) {
                temp[i] = i;
            }

            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

            int[] nums = new int[9];
            for (int i = 0; i < 9; i++) {
                nums[i] = Integer.parseInt(tokenizer.nextToken());
                temp[nums[i]] = 0;
            }
            Arrays.sort(nums);

            int index = 0;
            int[] target = new int[9];
            for (int i = 1; i < 19; i++) {
                if (temp[i] != 0) target[index++] = temp[i];
            }

            permutation(nums, target, 0);

            sb.append("#").append(problemNum++).append(" ");
            sb.append(win).append(" ").append(lose).append("\n");
        }
        System.out.println(sb);
    }

    private static void permutation(int[] nums, int[] target, int count) {
        if (count == 9) {
            int sumFirst = 0, sumSecond = 0;

            for (int i = 0; i < nums.length; i++) {
                int temp = nums[i] + selected[i];

                if (nums[i] > selected[i]) sumFirst += temp;
                else sumSecond += temp;
            }

            if (sumFirst > sumSecond) win++;
            else if (sumFirst < sumSecond) lose++;
        }

        for (int i = 0; i < target.length; i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                selected[count] = target[i];
                permutation(nums, target, count + 1);
                isSelected[i] = false;
            }
        }
    }

}
