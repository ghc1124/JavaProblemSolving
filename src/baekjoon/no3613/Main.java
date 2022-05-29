package baekjoon.no3613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String target = reader.readLine();

        // 조건 따지기
        // C++ 인가?

        if (target.matches(".*_.*")) {
            // 언더바가 있다. -> C++이다. -> Java로 바꾼다.
            if (target.matches(".*[A-Z].*")) {
                // 대문자가 있는 경우
                sb.setLength(0);
                sb.append("Error!");
            } else {
                for (int i = 0; i < target.length(); i++) {
                    if (target.charAt(i) == '_') {
                        if (i == 0 || i == target.length() - 1) {
                            sb.setLength(0);
                            sb.append("Error!");
                            break;
                        } else if (target.charAt(i + 1) == '_') {
                            sb.setLength(0);
                            sb.append("Error!");
                            break;
                        } else {
                            sb.append((char) (target.charAt(i + 1) + ('A' - 'a')));
                            i++;
                        }
                    } else {
                        sb.append(target.charAt(i));
                    }
                }
            }
        } else {
            // 언더바가 없다. -> Java이다. -> C++로 바꾼다.
            for (int i = 0; i < target.length(); i++) {
                if (target.charAt(i) >= 'A' && target.charAt(i) <= 'Z') {
                    if (i == 0) {
                        sb.setLength(0);
                        sb.append("Error!");
                        break;
                    } else {
                        sb.append("_");
                        sb.append((char) (target.charAt(i) - ('A' - 'a')));
                    }
                } else {
                    sb.append(target.charAt(i));
                }
            }
        }

        System.out.println(sb);
    }

}
