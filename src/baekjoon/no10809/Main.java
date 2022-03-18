package baekjoon.no10809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String target = reader.readLine();
        int[] check = new int[26];
        for (int i = 0; i < 26; i++) {
            check[i] = -1;
        }

        char[] temp = target.toCharArray();

        for (int i = 0; i < temp.length; i++) {
            if (check[temp[i] - 'a'] == -1) check[temp[i] - 'a'] = i;
        }

        for (int i = 0; i < 26; i++) {
            sb.append(check[i]).append(" ");
        }

        System.out.println(sb);
    }

}
