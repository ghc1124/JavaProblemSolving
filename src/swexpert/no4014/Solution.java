package swexpert.no4014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());    // 테스트케이스 개수

        for (int t = 0; t < T; t++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int N = Integer.parseInt(tokenizer.nextToken());    // 가로, 세로 길이
            int X = Integer.parseInt(tokenizer.nextToken());    // 경사로 길이

            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            int res = 0;

            // 행 탐색
            for (int i = 0; i < N; i++) {
                boolean flag = true;
                boolean[] slope = new boolean[N];

                Outer: for (int j = 1; j < N; j++) {
                    if (map[i][j - 1] != map[i][j]) {
                        if (Math.abs(map[i][j - 1] - map[i][j]) > 1) {
                            flag = false;
                            break;
                        }

                        int sum = 0;

                        if (map[i][j - 1] < map[i][j]) {    // 왼쪽이 더 작은 경우
                            for (int c = 0; c < X; c++) {
                                if ((j - 1) - c >= 0 && !slope[(j - 1) - c] && map[i][j - 1] == map[i][(j - 1) - c]){
                                    sum += map[i][(j - 1) - c];
                                } else {
                                    flag = false;
                                    break Outer;
                                }
                            }

                            if (Math.floor(1.0 * sum / X) == map[i][j - 1]) { // 경사로 설치 가능
                                for (int c = 0; c < X; c++) {
                                    slope[(j - 1) - c] = true;
                                }
                            }
                        } else {                            // 오른쪽이 더 작은 경우
                            for (int c = 0; c < X; c++) {
                                if (j + c < N && !slope[j + c] && map[i][j] == map[i][j + c]) {
                                    sum += map[i][j + c];
                                } else {
                                    flag = false;
                                    break Outer;
                                }
                            }

                            if (Math.floor(1.0 * sum / X) == map[i][j]) { // 경사로 설치 가능
                                for (int c = 0; c < X; c++) {
                                    slope[j + c] = true;
                                }
                            }
                        }
                    }
                }

                if (flag) res++;
            }

            // 열 탐색
            for (int i = 0; i < N; i++) {
                boolean flag = true;
                boolean[] slope = new boolean[N];

                Outer: for (int j = 1; j < N; j++) {
                    if (map[j - 1][i] != map[j][i]) {
                        if (Math.abs(map[j - 1][i] - map[j][i]) > 1) {
                            flag = false;
                            break;
                        }

                        int sum = 0;

                        if (map[j - 1][i] < map[j][i]) {    // 위쪽이 더 작은 경우
                            for (int c = 0; c < X; c++) {
                                if ((j - 1) - c >= 0 && !slope[(j - 1) - c] && map[j - 1][i] == map[(j - 1) - c][i]){
                                    sum += map[(j - 1) - c][i];
                                } else {
                                    flag = false;
                                    break Outer;
                                }
                            }

                            if (Math.floor(1.0 * sum / X) == map[j - 1][i]) { // 경사로 설치 가능
                                for (int c = 0; c < X; c++) {
                                    slope[(j - 1) - c] = true;
                                }
                            }
                        } else {                            // 아래쪽이 더 작은 경우
                            for (int c = 0; c < X; c++) {
                                if (j + c < N && !slope[j + c] && map[j][i] == map[j + c][i]) {
                                    sum += map[j + c][i];
                                } else {
                                    flag = false;
                                    break Outer;
                                }
                            }

                            if (Math.floor(1.0 * sum / X) == map[j][i]) { // 경사로 설치 가능
                                for (int c = 0; c < X; c++) {
                                    slope[j + c] = true;
                                }
                            }
                        }
                    }
                }

                if (flag) res++;
            }

            sb.append("#").append(t + 1).append(" ");
            sb.append(res).append("\n");
        }

        System.out.println(sb);
    }

}
