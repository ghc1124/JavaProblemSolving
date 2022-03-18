package baekjoon.no20304;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        // 입력을 얻기 위한 reader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine()); // 관리자 패스워드의 최댓값
        int M = Integer.parseInt(reader.readLine()); // 해커가 사용한 패스워드 개수
        int finalScore = Integer.MIN_VALUE; // 최종 점수는 최댓값을 구하기 위한 것이므로 최댓값을 구하기 위한 변수
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine()); // StringTokenizer 설정
        int[] attacks = new int[M]; // 해커가 사용한 패스워드들을 담기 위한 배열
        for (int i = 0; i < attacks.length; i++) {
            attacks[i] = Integer.parseInt(tokenizer.nextToken()); // 해커가 사용한 패스워드 저장
        }

        for (int i = 0; i <= N; i++) {
            int securityScore = Integer.MAX_VALUE; // 해커가 사용한 패스워드들과 비교한 점수 최솟값을 구하기 위한 변수
            for (int j = 0; j < attacks.length; j++) {
                // 보안척도를 구하기 위한 메서드를 호출하고, 이때까지의 값 중에서 최솟값을 유지한다.
                securityScore = Math.min(securityScore, security(i, attacks[j]));
            }
            // 해커가 사용한 패스워드들과의 비교가 모두 끝나면 이때까지의 최댓값을 유지한다.
            finalScore = Math.max(finalScore, securityScore);
        }

        System.out.println(finalScore); // 최종 출력
    }

    private static int security(int num1, int num2) {
        StringBuilder sb = new StringBuilder(); // 이진수로 변환한 값들을 저장하기 위한 배열
        int temp = num1 ^ num2; // XOR. 서로 다른 자리의 개수를 구하기 위해 XOR 연산을 한다.
        int result = 0; // 개수를 카운트하기 위한 변수

        for (char c : Integer.toBinaryString(temp).toString().toCharArray()) {
            if (c == '1') result++; // 전체 StringBuilder를 돌면서 1의 개수를 카운팅한다.
        }

        return result; // 개수 반환
    }

}
