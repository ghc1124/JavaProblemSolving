package baekjoon.no1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static String vowel = "aeiou";
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int L = Integer.parseInt(tokenizer.nextToken());
        int C = Integer.parseInt(tokenizer.nextToken());
        String[] target = reader.readLine().split(" ");

        Arrays.sort(target);

        combination(target, 0, 0, C, L, new StringBuilder(), 0, 0);

        System.out.println(answer);
    }

    // 대상 문자열 배열, 시작 인덱스, 현재 갯수, 배열 길이, 뽑아야하는 갯수, 문자열 저장용, 모음 수, 자음 수
    private static void combination(String[] target, int start, int currCnt, int totalCnt, int limit, StringBuilder sb, int vowelCnt, int consonantCnt) {
        if (currCnt == limit) {
            if (vowelCnt >= 1 && consonantCnt >= 2) answer.append(sb).append("\n");
            return;
        }

        for (int i = start; i < totalCnt; i++) {
            int currSize = sb.length();
            String temp = target[i];
            sb.append(target[i]);
            if (vowel.contains(temp)) combination(target, i + 1, currCnt + 1, totalCnt, limit, sb, vowelCnt + 1, consonantCnt);
            else combination(target, i + 1, currCnt + 1, totalCnt, limit, sb, vowelCnt, consonantCnt + 1);
            sb.setLength(currSize);
        }
    }

}
