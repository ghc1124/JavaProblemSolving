package test;

import java.io.IOException;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * 숫자로 시작 -> 00A, 00B
         */

        String pattern = "[ ]";
        String target = "RegExr was created by gskinner.com, and is proudly hosted by Media Temple.";

        System.out.println(target.replaceAll(pattern, "?"));
        // Pattern.matches(정규표현, 대상); -> true || false 로 말해줌
    }

}
