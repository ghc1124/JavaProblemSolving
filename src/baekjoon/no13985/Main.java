package baekjoon.no13985;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String target = reader.readLine();
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(target);

        int a = 0, b = 0, c = 0;

        if (matcher.find()) a = target.charAt(matcher.start()) - '0';
        if (matcher.find()) b = target.charAt(matcher.start()) - '0';
        if (matcher.find()) c = target.charAt(matcher.start()) - '0';

        System.out.println(a + b == c ? "YES" : "NO");
    }

}
