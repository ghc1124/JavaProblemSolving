package baekjoon.no1359;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int[] nums;
    private static int N, M, K;
    private static List<String> lottoList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        K = Integer.parseInt(tokenizer.nextToken());

        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = i + 1;
        }

        combination(0, 0, new StringBuilder());

        int size = lottoList.size();
        int totalCnt = 0;

        for (String temp : lottoList) {
            for (String s : lottoList) {
                int cnt = 0;
                for (int k = 0; k < M; k++) {
                    if (s.contains(temp.charAt(k) + "")) cnt++;
                }

                if (cnt >= K) totalCnt++;
            }
        }

        System.out.println((double) totalCnt / (size * size));
    }

    private static void combination(int start, int cnt, StringBuilder sb) {
        if (cnt == M) {
            lottoList.add(sb.toString());
            return;
        }

        for (int i = start; i < N; i++) {
            int temp = sb.length();
            sb.append(nums[i]);
            combination(i + 1, cnt + 1, sb);
            sb.setLength(temp);
        }
    }

}
