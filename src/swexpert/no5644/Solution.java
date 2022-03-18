package swexpert.no5644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static class AP {

        int X, Y, C, P; // x 좌표, y 좌표, 충전 범위, 처리량

        public AP(int x, int y, int c, int p) {
            X = x;
            Y = y;
            C = c;
            P = p;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        int problemNum = 1;

        for (int i = 0; i < T; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int M = Integer.parseInt(tokenizer.nextToken()); // 이동 시간
            int A = Integer.parseInt(tokenizer.nextToken()); // BC의 갯수
            int[] personA = new int[M]; // A의 이동 경로
            int[] personB = new int[M]; // B의 이동 경로

            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < M; j++) {
                personA[j] = Integer.parseInt(tokenizer.nextToken());
            }

            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < M; j++) {
                personB[j] = Integer.parseInt(tokenizer.nextToken());
            }

            List<AP> list = new ArrayList<>();

            for (int j = 0; j < A; j++) {
                tokenizer = new StringTokenizer(reader.readLine());
                list.add(
                        new AP(Integer.parseInt(tokenizer.nextToken()),
                                Integer.parseInt(tokenizer.nextToken()),
                                Integer.parseInt(tokenizer.nextToken()),
                                Integer.parseInt(tokenizer.nextToken()))
                );
            }

            sb.append("#").append(problemNum++).append(" ");
            sb.append(traversal(list, personA, personB, M)).append("\n");
        }
        System.out.println(sb);
    }

    // 경로 진행
    private static int traversal(List<AP> list, int[] personA, int[] personB, int M) {
        int[][] directions = {
            { 0, 0 }, // 이동하지 않음
            { -1, 0 }, // 상
            { 0, 1 }, // 우
            { 1, 0 }, // 하
            { 0, -1 }, // 좌
        };

        int sum = 0;

        // 처음 위치 설정
        int y_A = 1;
        int x_A = 1;
        int y_B = 10;
        int x_B = 10;

        int size = list.size();

        for (int i = 0; i <= M; i++) {
            int tempMax = 0;

            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    int temp = 0;
                    int powerA = searchAP(list, j, y_A, x_A);
                    int powerB = searchAP(list, k, y_B, x_B);

                    if (j != k) temp = powerA + powerB;
                    else temp = Math.max(powerA, powerB);

                    tempMax = Math.max(tempMax, temp);
                }
            }

            sum += tempMax;

            if (i < M) {
                y_A += directions[personA[i]][0];
                x_A += directions[personA[i]][1];
                y_B += directions[personB[i]][0];
                x_B += directions[personB[i]][1];
            }
        }

        return sum;
    }

    // 주위 AP 탐색
    private static int searchAP(List<AP> list, int index, int i, int j) {
        AP ap = list.get(index);

            // 좌표가 해당 AP의 범위 내에 있을 경우
        return ((Math.abs(ap.Y - i) + Math.abs(ap.X - j)) <= ap.C) ? ap.P : 0;
    }

}
