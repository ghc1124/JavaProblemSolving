package baekjoon.no2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken()); // 전체 나무의 수
        int M = Integer.parseInt(tokenizer.nextToken()); // 필요한 나무의 길이
        tokenizer = new StringTokenizer(reader.readLine()); // 전체 나무의 높이

        int result = 0;

        int[] trees = new int[N];
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(tokenizer.nextToken());
        }

        // 나무가 1개일 때
        if (N == 1) result = trees[0] - M;
        else {
            Arrays.sort(trees); // 오름차순 정렬

            if (trees[0] == trees[N - 1]) { // 모든 나무의 길이가 같은 경우
                result = trees[0] - (int) Math.ceil(1.0 * M / N);
            } else {
                int temp = 1;

                for (int i = N - 1; i > 0; i--) {
                    int diff = (trees[i] - trees[i - 1]) * temp;
                    if (diff < M) {
                        M -= diff;
                    } else {
                        if (diff == M) {
                            result = trees[i - 1];
                        } else {
                            result = trees[i] - (int) Math.ceil(1.0 * M / temp);
                        }
                        break;
                    }
                    temp++;
                }
            }
        }

        System.out.println(result);
    }

}
