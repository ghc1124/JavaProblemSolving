package swexpert.no1289;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        int num = 1;
        while (N-- > 0) {
            int count = 0;
            char[] target = reader.readLine().toCharArray();
            if (target[0] == '1')
                count++;
            for (int i = 0; i < target.length - 1; i++) {
                if (target[i] != target[i + 1]) {
                    count++;
                }
            }
            sb.append("#").append(num++).append(" ").append(count).append("\n");
        }

        System.out.println(sb);
    }

}