package baekjoon.no2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        int startIndex = 1;         // 시작 인덱스
        int endIndex = 1;           // 끝 인덱스
        int count = 1;              // 마지막에 하나로 되는 경우 미리 계산
        int sum = 1;                // 시작이 1이다.

        while (endIndex != N) {
            if (sum == N) {         // 값 찾음
                count++;
                sum -= startIndex;
                startIndex++;
            } else if (sum > N) {   // 값 초과
                sum -= startIndex;
                startIndex++;
            } else {                // 값 미달
                endIndex++;
                sum += endIndex;
            }
        }

        System.out.println(count);
    }

}
