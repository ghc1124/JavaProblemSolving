package baekjoon.no1264;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String target = reader.readLine();

            if (target.equals("#")) break;

            Pattern pattern = Pattern.compile("[aeiouAEIOU]");
            Matcher matcher = pattern.matcher(target);

            int cnt = 0;

            while (matcher.find()) {
                cnt++;
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }

}
