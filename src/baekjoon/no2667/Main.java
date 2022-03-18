package baekjoon.no2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int[][] directions = {
            { -1, 0 }, // 상
            { 1, 0 },  // 하
            { 0, -1 }, // 좌
            { 0, 1 },  // 우
    };

    private static int count = 1;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[][] arr = new int[N][N];
        int groupCount = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] temp = reader.readLine().split("");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(temp[j]);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 1) {
                    groupCount++;
                    arr[i][j] = 0;
                    dfs(arr, i, j);
                    list.add(count);
                    count = 1;
                }
            }
        }

        sb.append(groupCount).append("\n");
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int[][] arr, int x, int y) {
        for (int i = 0; i < 4; i++) {
            int dx = x + directions[i][0];
            int dy = y + directions[i][1];

            if (dx >= 0 && dx < arr.length && dy >= 0 && dy < arr.length) {
                if (arr[dx][dy] == 1) {
                    count++;
                    arr[dx][dy] = 0;
                    dfs(arr, dx, dy);
                }
            }
        }
    }

    /*private static int bfs(int[][] arr, int[] startPoint) {
        Queue<int[]> queue = new ArrayDeque<>(); // 배열로 표현된 좌표를 담는 큐
        queue.offer(startPoint);

        int count = 1;

        while (!queue.isEmpty()) {
            int[] point = queue.poll();

            for (int i = 0; i < 4; i++) {
                int dx = point[0] + directions[i][0];
                int dy = point[1] + directions[i][1];

                // 유효범위일 경우
                if (dx >= 0 && dx < arr.length && dy >= 0 && dy < arr.length) {
                    if (arr[dx][dy] == 1) {
                        count++;
                        arr[dx][dy] = 0;
                        queue.offer(new int[] { dx, dy });
                    }
                }
            }
        }

        return count;
    }*/

}
