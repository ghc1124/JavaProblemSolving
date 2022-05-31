package baekjoon.no2174;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }, }; // N, E, S, W 순서

    private static class Robot {

        int direction;    // 로봇 방향
        int y;            // y 좌표
        int x;            // x 좌표

        public Robot(int direction, int y, int x) {
            this.direction = direction;
            this.y = y;
            this.x = x;
        }

    }

    private static int[][] map;
    private static Robot[] robots;
    private static int A, B;
    private static StringBuilder sb = new StringBuilder("OK");

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());    // 테스트케이스 개수

        for (int t = 0; t < T; t++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

            sb = new StringBuilder("OK");

            A = Integer.parseInt(tokenizer.nextToken());    // 가로(열)
            B = Integer.parseInt(tokenizer.nextToken());    // 세로(행)

            map = new int[B + 1][A + 1];

            tokenizer = new StringTokenizer(reader.readLine());

            int N = Integer.parseInt(tokenizer.nextToken());    // 로봇의 수
            int M = Integer.parseInt(tokenizer.nextToken());    // 명령의 수

            robots = new Robot[N + 1];

            for (int i = 1; i <= N; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                int x = Integer.parseInt(tokenizer.nextToken());    // x 좌표
                int y = Integer.parseInt(tokenizer.nextToken());    // y 좌표
                String direction = tokenizer.nextToken();           // 방향

                robots[i] = new Robot(findDirection(direction), y, x);

                map[y][x] = i;
            }

//        for (int[] row : map) {
//            System.out.println(Arrays.toString(row));
//        }

//        System.out.println();

            // 명령
            for (int i = 0; i < M; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                int num = Integer.parseInt(tokenizer.nextToken());  // 로봇 번호
                String command = tokenizer.nextToken(); // 명령
                int repeat = Integer.parseInt(tokenizer.nextToken());   // 반복 횟수

                if (sb.length() > 2) {
                    // 값의 변화가 생김 -> 끝
                    continue;
                }

                for (int j = 0; j < repeat; j++) {
                    performCommand(command, num);
                }

//            for (int[] row : map) {
//                System.out.println(Arrays.toString(row));
//            }
//            System.out.println();
            }

            System.out.println(sb);
        }
    }

    private static void performCommand(String command, int num) {
        Robot current = robots[num];
//        System.out.println("direction: " + current.direction);

        if (command.equals("L")) {
            if (--current.direction < 0) {
                current.direction = 3;
            }
        } else if (command.equals("R")) {
            if (++current.direction > 3) {
                current.direction = 0;
            }
        } else {
            // 전진
            int dy = current.y + directions[current.direction][0];
            int dx = current.x + directions[current.direction][1];

            if (dy >= 1 && dy <= B && dx >= 1 && dx <= A) {
                if (map[dy][dx] != 0) {
                    sb.setLength(0);
                    sb.append("Robot ").append(num).append(" crashes into robot ").append(map[dy][dx]);
                } else {
                    map[dy][dx] = num;
                    map[current.y][current.x] = 0;
                    current.y = dy;
                    current.x = dx;
                }
            } else {
                sb.setLength(0);
                sb.append("Robot ").append(num).append(" crashes into the wall");
            }
        }
    }

    private static int findDirection(String target) {
        switch (target) {
            case "N":
                return 0;

            case "E":
                return 1;

            case "S":
                return 2;

            default:
                return 3;
        }
    }

}
