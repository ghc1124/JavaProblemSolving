package baekjoon.no17406;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    // 모든 순열의 경우의 수를 저장할 리스트
    private static ArrayList<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int result = Integer.MAX_VALUE; // 최솟값을 찾기 위한 처리

        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        int R = Integer.parseInt(tokenizer.nextToken()); // 회전 연산 개수
        int[][] matrix = new int[N][M];
        int[][] backup = new int[N][M]; // 다른 경우를 진행하기 위해 원본 배열 값을 저장

        // 배열 저장
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                backup[i][j] = matrix[i][j];
            }
        }

        int[][] target = new int[R][3]; // 회전 연산 명령을 저장하기 위한 배열
        int[] arr = new int[R]; // 회전 연산 명령 배열의 호출 순서를 정하기 위한 배열

        for (int i = 0; i < R; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            target[i][0] = Integer.parseInt(tokenizer.nextToken());
            target[i][1] = Integer.parseInt(tokenizer.nextToken());
            target[i][2] = Integer.parseInt(tokenizer.nextToken());
            arr[i] = i;
        }

        // 시계 방향 진행을 위한 벡터
        int[][] directions = {
                { 0, 1 },
                { 1, 0 },
                { 0, -1 },
                { -1, 0 },
        };

        // R개 중 R개를 뽑는 순열을 진행하여 모든 나열할 수 있는 경우의 수 구함
        permutation(arr, new boolean[R], 0, new int[R], R);

        for (int[] value : list) {
            for (int i = 0; i < value.length; i++) {
                int startRow = target[value[i]][0] - target[value[i]][2] - 1; // 가장 왼쪽 위 행
                int startCol = target[value[i]][1] - target[value[i]][2] - 1; // 가장 왼쪽 위 열
                int endRow = target[value[i]][0] + target[value[i]][2] - 1; // 가장 오른쪽 아래 행
                int endCol = target[value[i]][1] + target[value[i]][2] - 1; // 가장 오른쪽 아래 열

                // 진행할 사각형의 수. 가로, 세로 길이 중 짧은 것을 2로 나눈 값(ceil)
                int square = (int) Math.ceil(Math.min(endRow - startRow + 1, endCol - startCol + 1) / 2.0);

                while (square-- > 0) {
                    int x = startRow;
                    int y = startCol;
                    int save = matrix[x][y]; // 현재 사각형 내 가장 왼쪽 값을 저장. 그 옆의 값부터 진행된다.

                    int index = 0; // 방향 벡터 배열의 인덱스

                    while (index < directions.length) {
                        int dx = x + directions[index][0]; // 현재 위치에서 벡터 값을 더한 행
                        int dy = y + directions[index][1]; // 현재 위치에서 벡터 값을 더한 열

                        // 유효한 범위 내일 경우
                        if (dx >= startRow && dx <= endRow && dy >= startCol && dy <= endCol) {
                            int current = matrix[dx][dy]; // 지금 보고 있는 좌표의 값 저장
                            matrix[dx][dy] = save; // 전에 저장해둔 이전값을 현재 좌표에 저장(shift)
                            save = current; // 원래의 값을 save 변수에 저장하여 다음 자리에 넣을 수 있도록 기억
                            x = dx; // 현재 위치 업데이트
                            y = dy; // 현재 위치 업데이트
                        } else {
                            index++; // 유효한 범위를 벗어났을 경우 다음 벡터 방향으로 전환
                        }
                    }

                    // 4방향 벡터 처리를 다 한 경우, 그 다음 안쪽 사각형을 돌리기 위해 경계 조정
                    startRow++;
                    startCol++;
                    endRow--;
                    endCol--;
                }
            }

            for (int[] row : matrix) {
                int sum = 0;
                for (int col : row) {
                    sum += col;
                }
                result = Math.min(result, sum);
            }


            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    matrix[i][j] = backup[i][j];
                }
            }
        }

        writer.write(Integer.toString(result));
        writer.flush();
        writer.close();
    }

    private static void permutation(int[] arr, boolean[] isSelected, int count, int[] answer, int R) {
        if (count == R) {
            int[] temp = new int[R]; // 깊은 복사
            for (int i = 0; i < R; i++) {
                temp[i] = answer[i];
            }
            list.add(temp); // 리스트에 저장
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                answer[count] = arr[i];
                permutation(arr, isSelected, count + 1, answer, R);
                isSelected[i] = false;
            }
        }
    }

}
