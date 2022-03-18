package baekjoon.no10157;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt(); // 가로
        int N = scanner.nextInt(); // 세로
        int K = scanner.nextInt(); // 타겟

        boolean[][] visited = new boolean[N][M];

        if (K > N * M) {
            System.out.println(0);
            return;
        } else {
            int[][] directions = {
                    { 1, 0 },
                    { 0, 1 },
                    { -1, 0 },
                    { 0, -1 },
            };

            int num = 1;
            int index = 0;
            int i = 0, j = 0;
            visited[i][j] = true;

            if (num++ == K) {
                System.out.println((i + 1) + " " + (i + 1));
                return;
            } else {
                while (num <= N * M) {
                    int dx = i + directions[index % 4][0];
                    int dy = j + directions[index % 4][1];

                    if (dx >= 0 && dx < N && dy >= 0 && dy < M && !visited[dx][dy]) {
                            visited[dx][dy] = true;
                            if (num++ == K) {
                                System.out.println((dy + 1) + " " + (dx + 1));
                                return;
                            }
                            i = dx;
                            j = dy;
                            continue;
                    } else {
                        index++;
                    }
                }
            }
        }
    }

}
