package baekjoon.no15666;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken()); // N개의 자연수 중
        int M = Integer.parseInt(tokenizer.nextToken()); // M개를 고름
        tokenizer = new StringTokenizer(reader.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(arr); // 사전순 출력 위한 정렬

        combiRepeat(arr, 0, 0, M, new StringBuilder());

        System.out.println(result);
    }

    private static void combiRepeat(int[] arr, int start, int count, int M, StringBuilder sb) {
        if (count == M) {
            result.append(sb).append("\n");
            return;
        }

        int temp = 0; // 직전에 처리한 수를 기억하기 위한 변수

        for (int i = start; i < arr.length; i++) {
            if (arr[i] != temp) {
                int size = sb.length();
                sb.append(arr[i]).append(" ");
                combiRepeat(arr, i, count + 1, M, sb);
                sb.setLength(size);
                temp = arr[i];
            }
        }
    }

}
