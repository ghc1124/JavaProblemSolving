package swexpert.no3499;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        int problemNum = 1;

        while (T-- > 0) {
            int size = Integer.parseInt(reader.readLine());
            ArrayList<String> list = new ArrayList<>();
            ArrayList<String> result = new ArrayList<>();
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < size; i++) {
                list.add(tokenizer.nextToken());
            }

            int shuffle = (int) Math.ceil(size / 2.0); // 이게 기점
            // A B C | D E F, 0 1 2 | 3 4 5
            for (int i = 0; i < size - shuffle; i++) {
                result.add(list.get(i));
                result.add(list.get(i + shuffle));
            }

            if (size % 2 == 1) result.add(list.get(shuffle - 1));

            sb.append("#").append(problemNum++).append(" ");
            for (String str : result) {
                sb.append(str).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

}
