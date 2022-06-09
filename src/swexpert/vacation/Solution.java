package swexpert.vacation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    private static int[] students;
    private static int res = -1;
    private static int ans, N;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine());    // 학생 수
        char[] temp = reader.readLine().toCharArray();
        int problemCnt = temp.length;

        StringBuilder sb = new StringBuilder();
        for (char c : temp) {
            sb.append(c == 'O' ? 1 : 0);
        }

        ans = Integer.parseInt(sb.toString(), 2);   // 정답

        students = new int[N];
        for (int i = 0; i < N; i++) {
            temp = reader.readLine().toCharArray();
            sb.setLength(0);
            for (char c : temp) {
                sb.append(c == 'O' ? 1 : 0);
            }
            students[i] = Integer.parseInt(sb.toString(), 2);   //  학생들의 정답
        }

        combination(0, 0, 0);
    }

    private static void combination(int index, int cnt, int curr) {
        if (cnt == N) {
            // 다 뽑은 경우
            if (curr == ans) {
                System.out.println(cnt);
            }
            return;
        }

        if (curr == ans) {
            System.out.println(cnt);
            return;
        }

        for (int i = index; i < N; i++) {
            combination(i + 1, cnt + 1, curr | students[i]);
        }
    }

}
