package baekjoon.no17070;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static class Node {

        int y;
        int x;
        int status; // 0: 가로, 1: 세로, 2: 대각선

        public Node(int y, int x, int status) {
            this.y = y;
            this.x = x;
            this.status = status;
        }

    }

    private static int[][] directions = { { 0, 1 }, { 1, 1 }, { 1, 0 } };   // 가로, 대각선, 세로 움직임

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());    // 집의 크기

        int[][] house = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < N; j++) {
                house[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0, 1, 0)); // 좌표에서는 파이프의 마지막 위치를 기억하고 있다.

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

//            boolean[]
        }
    }

}
