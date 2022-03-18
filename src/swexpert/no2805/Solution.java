package swexpert.no2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int problemNum = 1;

        while (N-- > 0) {
            int size = Integer.parseInt(reader.readLine());
            int start = -1;
            int end = -1;
            String[] target;
            int result = 0;

            for (int i = 0; i < size; i++) {
                if (i <= size / 2) {
                    start = size / 2 - i;
                    end = size / 2 + i + 1;
                } else {
                    start = i - size / 2;
                    end = size - (i - size / 2);
                }
                target = reader.readLine().substring(start, end).split("");
                for (int j = 0; j < target.length; j++) {
                    result += Integer.parseInt(target[j]);
                }
            }

            sb.append("#").append(problemNum++).append(" ");
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

}
