package swexpert.no1873;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    private static char[][] battleField;
    private static StringBuilder sb = new StringBuilder();
    private static int problemNum = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        while (N-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int rowSize = Integer.parseInt(tokenizer.nextToken());
            int colSize = Integer.parseInt(tokenizer.nextToken());

            battleField = new char[rowSize][colSize];
            for (int i = 0; i < rowSize; i++) { // 배열 구성
                battleField[i] = reader.readLine().toCharArray();
            }
            int commandSize = Integer.parseInt(reader.readLine()); // 명령 길이
            String command = reader.readLine();
            battle(command);
        }

        System.out.println(sb);
    }

    // 평지인 경우 평지와 탱크 위치 교환
    private static void swap(int from_i, int from_j, int to_i, int to_j) {
        char temp = battleField[from_i][from_j];
        battleField[from_i][from_j] = battleField[to_i][to_j];
        battleField[to_i][to_j] = temp;
    }

    // S 처리 메서드
    private static void shoot(int[] location, char state) {
        int[][] directions = { // U, D, L, R
                { -1, 0 },
                { 1, 0 },
                { 0, -1 },
                { 0, 1 },
        };

        // 방향 설정
        int direction = state == '^' ? 0 : state == 'v' ? 1 : state == '<' ? 2 : 3;
        int dx = location[0] + directions[direction][0];
        int dy = location[1] + directions[direction][1];

        while (dx >= 0 && dx < battleField.length && dy >= 0 && dy < battleField[0].length) {
            if (battleField[dx][dy] == '#') { // 강철벽일 경우 멈춤
                break;
            } else if (battleField[dx][dy] == '*') { // 벽돌벽일 경우 평지가 됨
                battleField[dx][dy] = '.';
                break;
            }
            dx += directions[direction][0];
            dy += directions[direction][1];
        }
    }

     // U, D, L, R 처리 메서드
    private static int[] move(int[] location, char state) {
        int[][] directions = { // U, D, L, R
                { -1, 0 },
                { 1, 0 },
                { 0, -1 },
                { 0, 1 },
        };

        // 방향 설정
        int direction = state == '^' ? 0 : state == 'v' ? 1 : state == '<' ? 2 : 3;
        int dx = location[0] + directions[direction][0];
        int dy = location[1] + directions[direction][1];

        if (dx >= 0 && dx < battleField.length && dy >= 0 && dy < battleField[0].length) {
            if (battleField[dx][dy] == '.') {
                swap(dx, dy, location[0], location[1]);
                location[0] = dx;
                location[1] = dy;
            }
        }

        return location;
    }

    // 로직 처리 메서드
    private static void battle(String command) {
        int[] location = { -1, -1 };
        char state = ' ';

        // 처음 위치 찾기
        Outer: for (int i = 0; i < battleField.length; i++) {
            for (int j = 0; j < battleField[i].length; j++) {
                if (battleField[i][j] == ('^')
                    || battleField[i][j] == ('v')
                    || battleField[i][j] == ('<')
                    || battleField[i][j] == ('>')) {
                    location[0] = i;
                    location[1] = j;
                    state = battleField[i][j];
                    break Outer;
                }
            }
        }

        // 명령을 하나씩 처리
        for (char c : command.toCharArray()) {
            if (c == 'U' || c == 'D' || c == 'L' || c == 'R') {
                switch (c) {
                    case 'U':
                        battleField[location[0]][location[1]] = '^';
                        state = '^';
                        location = move(location, state);
                        break;

                    case 'D':
                        battleField[location[0]][location[1]] = 'v';
                        state = 'v';
                        location = move(location, state);
                        break;

                    case 'L':
                        battleField[location[0]][location[1]] = '<';
                        state = '<';
                        location = move(location, state);
                        break;

                    case 'R':
                        battleField[location[0]][location[1]] = '>';
                        state = '>';
                        location = move(location, state);
                        break;
                }
            } else { // S인 경우 -> 강철벽일 경우 막힘, 벽돌은 평지가 됨
                shoot(location, state);
            }
        }

        if (problemNum > 1) {
            sb.append("\n");
        }

        sb.append("#").append(problemNum++).append(" ");
        for (char[] row : battleField) {
            for (char col : row) {
                sb.append(col);
            }
            sb.append("\n");
        }
        sb.setLength(sb.length() - 1);
    }

}
