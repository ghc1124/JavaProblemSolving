package swexpert.no1767;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    private static int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    private static int max, min, totalCnt, N;
    private static int[][] matrix;
    private static List<int[]> core;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine()); // 테스트케이스 개수

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(reader.readLine());
            matrix = new int[N][N];
            core = new ArrayList<>();

            /**
             * 전선 연결을 하고 안하고 두 가지를 생각해봐야함. -> 부분집합(5C1, 5C2 ...)
             */

            max = 0;                    // 최대 연결 코어 수
            min = Integer.MAX_VALUE;    // 최소 전선길이 합
            totalCnt = 0;               // 가장자리가 아닌 코어의 개수

            for (int i = 0; i < N; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                    if (matrix[i][j] == 1 && i != 0 && i != N - 1 && j != 0 && j != N - 1) {
                        core.add(new int[] { i, j });
                        totalCnt++;
                    }
                }
            }

            go(0, 0);

            sb.append("#").append(t + 1).append(" ");
            sb.append(min).append("\n");
        }

        System.out.println(sb);
    }

    private static void go(int index, int coreCnt) {            // 부분집합으로 코어 전선놓기 시도. coreCnt: 전원과 연결된 코어 수
        if (index == totalCnt) {
            int temp = getLength();
            if (max < coreCnt) {    // 현재 연결된 코어 수가 더 큰 경우 무조건 전선 길이 합 갱신
                max = coreCnt;
                min = temp;
            } else if (max == coreCnt) {    // 코어 수가 같은 경우 더 작은 전선 길이 합으로 갱신
                if (min > temp) min = temp;
            }

            return;
        }

        int[] curr = core.get(index); // 처리 대상 코어
        int r = curr[0]; // 행
        int c = curr[1]; // 열

        /**
         * 부분집합. 전선을 놓아보고 그 다음 안놓아보고. 반복
         */

        // 전선 놓기(4방)
        for (int d = 0; d < 4; d++) {
            if (isAvailable(r, c, d)) {     // 현재 위치에서 놓을 수 있는지 체크
                setStatus(r, c, d, 2);   // 전선 놓기
                go(index + 1, coreCnt + 1); // 다음 코어
                setStatus(r, c, d, 0);   // 전선 지우기
            }
        }

        // 전선 안놓기
        go(index + 1, coreCnt); // 건너뛰기
    }

    private static boolean isAvailable(int r, int c, int d) {   // r, c 위치에서 d 방향으로 전선을 놓을 수 있는지 체크
        int dy = r, dx = c;

        while (true) {
            // 우선 증가
            dy += directions[d][0];
            dx += directions[d][1];

            if (dy < 0 || dy >= N || dx < 0 || dx >= N) break;

            if (matrix[dy][dx] > 0) return false;  // 다른 코어나 전선을 만나면 false
        }

        return true;
    }

    private static void setStatus(int r, int c, int d, int s) { // r, c 위치에서 d 방향으로 전선을 놓거나 치우거나
        int dy = r, dx = c;

        while (true) {
            // 우선 증가
            dy += directions[d][0];
            dx += directions[d][1];

            if (dy < 0 || dy >= N || dx < 0 || dx >= N) break;

            matrix[dy][dx] = s;
        }
    }

    private static int getLength() {                            // 놓아진 전선의 길이 합 계산
        int lCnt = 0;
        for (int r = 0; r < N; r++) {                           // 행렬 순회
            for (int c = 0; c < N; c++) {
                if (matrix[r][c] == 2) lCnt++;                  // 전선 길이 합 계산
            }
        }

        return lCnt;
    }

}
