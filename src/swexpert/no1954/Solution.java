package swexpert.no1954;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    private static StringBuilder sb = new StringBuilder(); // 출력 저장용
    private static int problemNum = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine()); // 사이즈

        while (N-- > 0) {
            snail(Integer.parseInt(reader.readLine()));
        }

        System.out.println(sb);
        reader.close();
    }

    private static void snail(int size) {
        int[][] matrix = new int[size][size]; // 배열 생성
        int[][] directions = { // 진행 방향(오 -> 아래 -> 왼 -> 위)
                { 0, 1 },
                { 1, 0 },
                { 0, -1 },
                { -1, 0 },
        };

        int row = 0; // 행
        int col = 0; // 열
        int direction = 0; // 방향 벡터 설정을 위한 변수
        int num = 1; // 배열에 넣을 값
        int count = 1; // 현재 차수

        /*
        처음 시행(1행 채워넣기) 외에 나머지는 2번씩 진행하고 N을 1 감소
        ex) 입력이 3인 경우, 처음에는 0부터 N 전까지 즉, 3번 채워넣는다. (1 2 3)
        처음 시행은 바로 N을 감소시킨다. (N -> 2)
        다음 시행부터는 2회 진행 후 N을 감소시킨다.
        N이 0이되면 종료한다.
        */
        while (size > 0) {
            // N - 1번 이동
            for (int i = 0; i < size - 1; i++) {
                matrix[row][col] = num++;
                row += directions[direction % 4][0];
                col += directions[direction % 4][1];
            }
            matrix[row][col] = num++; // 최종 이동한 자리에 값 넣고
            count++; // 차수 증가
            direction++; // 방향 벡터 변수 증가
            row += directions[direction % 4][0]; // 다음 방향으로 셋팅
            col += directions[direction % 4][1]; // 다음 방향으로 셋팅
            if (count % 2 == 0) {
                size--;
            }
        }

        sb.append("#").append(problemNum++).append("\n");
        for (int[] x : matrix) {
            for (int y : x) {
                sb.append(y).append(" ");
            }
            sb.append("\n");
        }
    }

}
