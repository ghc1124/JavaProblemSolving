package baekjoon.no1316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int result = 0;

        while (N-- > 0) {
            int[] alphabet = new int[26];
            char[] target = reader.readLine().toCharArray();
            boolean flag = false;
            for (int i = 0; i < target.length; i++) {
                int temp = target[i] - 'a';
                if (++alphabet[temp] >= 2) {
                    if (target[i - 1] != target[i]) {
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag) result++;
        }

        System.out.println(result);
    }

}
