package swexpert.no4012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    private static int[][] ingredients;
    private static int N;
    private static int sum;
    private static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine()); // 테케 갯수
        StringBuilder sb = new StringBuilder();
        int problemNum = 1;

        for (int i = 0; i < T; i++) {
            int result = Integer.MAX_VALUE;
            N = Integer.parseInt(reader.readLine()); // 식재료의 수
            ingredients = new int[N][N];
            for (int j = 0; j < N; j++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int k = 0; k < N; k++) {
                    ingredients[j][k] = Integer.parseInt(tokenizer.nextToken());
                }
            }
            list = new ArrayList<>();
            int[] index = new int[N / 2];
            combination(index, 0, N / 2, 0);
            int s = 0, k = list.size() - 1;
            while (s < k) {
                result = Math.min(result, Math.abs(list.get(s++) - list.get(k--)));
            }
            sb.append("#").append(problemNum++).append(" ");
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    private static void combination(int[] index, int count, int R, int start) {
        if (count == R) {
            // 절반의 재료를 선택했을 때
            sum = 0;
            permutation(index, new int[2], 0, 2, 0);
            list.add(sum);
            return;
        }

        for (int i = start; i < N; i++) {
            index[count] = i;
            combination(index, count + 1, R, i + 1);
        }
    }

    private static void permutation(int[] index, int[] ans, int count, int R, int flag) {
        if (count == R) { // 2개 선택
            sum += ingredients[ans[0]][ans[1]];
            return;
        }

        for (int i = 0; i < index.length; i++) {
            if ((flag & 1 << i) == 0) {
                ans[count] = index[i];
                permutation(index, ans, count + 1, R, flag | 1 << i);
            }
        }
    }
    
}
