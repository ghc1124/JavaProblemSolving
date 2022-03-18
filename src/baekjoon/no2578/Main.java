package baekjoon.no2578;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static boolean leftToRight = false;
    private static boolean rightToLeft = false;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[][] bingo = new int[5][5];
        int bingoCount = 0;
        int result = 0;

        for (int i = 0; i < 5; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        Outer: for (int i = 0; i < 5; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < 5; j++) {
                bingoCount += findBingo(bingo, Integer.parseInt(tokenizer.nextToken()));

                if (bingoCount >= 3) {
                    result = i * 5 + (j + 1);
                    break Outer;
                }
            }
        }

        System.out.println(result);
    }

    private static int findBingo(int[][] bingo, int answer) {
        int targetX = 0; // 찾을 행
        int targetY = 0; // 찾을 열

        int bingoCount = 0;

        // 대상 찾기
        Outer: for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (bingo[i][j] == answer) {
                    targetX = i;
                    targetY = j;
                    bingo[i][j] = 0;
                    break Outer;
                }
            }
        }

        // 찾았다면은, 빙고를 체크할 차례
        // 좌, 우 살피고 상, 하 살피고 대각은 제일 마지막

        // 좌, 우, 상, 하, 대각
        int[][] directions = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
        int directionIndex = 0; // 배열 인덱스

        int tempX = targetX;
        int tempY = targetY;
        int temp = 0; // 0 갯수 세기

        // 좌, 우
        while (directionIndex < 2) {
            int dx = tempX + directions[directionIndex][0];
            int dy = tempY + directions[directionIndex][1];

            if (dx >= 0&& dx < 5 && dy >= 0 && dy < 5) {
                // 0일 경우 계속 탐색
                if (bingo[dx][dy] == 0) {
                    temp++;
                    tempX = dx;
                    tempY = dy;
                    continue;
                } else {
                    break;
                }
            } else {
                tempX = targetX;
                tempY = targetY;
                directionIndex++;
            }
        }

        if (temp == 4) bingoCount++;

        tempX = targetX;
        tempY = targetY;
        temp = 0;

        directionIndex = 2;

        // 상, 하
        while (directionIndex < 4) {
            int dx = tempX + directions[directionIndex][0];
            int dy = tempY + directions[directionIndex][1];

            if (dx >= 0&& dx < 5 && dy >= 0 && dy < 5) {
                // 0일 경우 계속 탐색
                if (bingo[dx][dy] == 0) {
                    temp++;
                    tempX = dx;
                    tempY = dy;
                    continue;
                } else {
                    break;
                }
            } else {
                tempX = targetX;
                tempY = targetY;
                directionIndex++;
            }
        }

        if (temp == 4) bingoCount++;

        temp = 0;

        // 대각
        if (!leftToRight) {
            for (int i = 0; i < 5; i++) {
                if (bingo[i][i] == 0) {
                    temp++;
                } else {
                    break;
                }
            }

            if (temp == 5) {
                bingoCount++;
                leftToRight = true;
            }
        }

        temp = 0;

        // 대각
        if (!rightToLeft) {
            for (int i = 0; i < 5; i++) {
                if (bingo[i][4 - i] == 0) {
                    temp++;
                } else {
                    break;
                }
            }

            if (temp == 5) {
                bingoCount++;
                rightToLeft = true;
            }
        }


        return bingoCount;
    }

}
