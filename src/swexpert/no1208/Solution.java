package swexpert.no1208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int problemNum = 1;

        String temp = "";
        while ((temp = reader.readLine()) != null && !temp.equals("")) {
            int dump = Integer.parseInt(temp);
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int[] nums = new int[100];

            for (int i = 0; i < nums.length; i++) {
                if (tokenizer.hasMoreTokens()) {
                    nums[i] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            while (dump-- > 0) {
                Arrays.sort(nums);
                int test = nums[nums.length - 1] - nums[0];
                if (test == 1 || test == 0) {
                    break;
                }

                nums[nums.length - 1]--;
                nums[0]++;
            }

            Arrays.sort(nums);

            sb.append("#").append(problemNum++).append(" ");
            sb.append(nums[nums.length - 1] - nums[0]).append("\n");
        }

        System.out.println(sb);
    }

}
