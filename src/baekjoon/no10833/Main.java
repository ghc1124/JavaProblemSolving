package baekjoon.no10833;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());    // 학교 수

        int cnt = 0;    // 정답 저장

        StringTokenizer tokenizer = null;

        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int student = Integer.parseInt(tokenizer.nextToken());  // 학생 수
            int apple = Integer.parseInt(tokenizer.nextToken());    // 사과 수

            cnt += apple % student;
        }

        System.out.println(cnt);
    }

}
