package swexpert.no1218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int problemNum = 1;

        for (int i = 0; i < 10; i++) {
            Integer.parseInt(reader.readLine());
            sb.append("#").append(problemNum++).append(" ");
            sb.append(isPerfect(reader.readLine().toCharArray()) == true ? 1 : 0).append("\n");
        }

        System.out.println(sb);
    }

    private static boolean isPerfect(char[] chars) {
        Stack<Character> stack = new Stack<>();
        boolean result = true;

        for (char c : chars) {
            if (c == 40 || c == 60 || c == 91 || c == 123) {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    char target = stack.pop();
                    if (!(target + 1 == c || target + 2 == c)) {
                        result = false;
                        break;
                    }
                } else {
                    result = false;
                    break;
                }
            }
        }

        if (!stack.isEmpty()) result = false;

        return result;
    }

}
