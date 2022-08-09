import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 }, };
    private static char[][] war;
    private static boolean[][] isVisited;
    private static int N, M, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        M = Integer.parseInt(tokenizer.nextToken());    // 가로 크기(열)
        N = Integer.parseInt(tokenizer.nextToken());    // 세로 크기(행)

        war = new char[N][M];
        isVisited = new boolean[N][M];

        int whiteCnt = 0;
        int blueCnt = 0;

        for (int i = 0; i < N; i++) {
            war[i] = reader.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!isVisited[i][j]) {
                    cnt = 1;
                    isVisited[i][j] = true;
                    countSoldier(war[i][j], i, j);
                    if (war[i][j] == 'W') whiteCnt += cnt * cnt;
                    else blueCnt += cnt * cnt;
                }
            }
        }

        System.out.println(whiteCnt + " " + blueCnt);
    }

    private static void countSoldier(char c, int y, int x) {
        for (int i = 0; i < 4; i++) {
            int dy = y + directions[i][0];
            int dx = x + directions[i][1];

            if (dy >= 0 && dy < N && dx >= 0 && dx < M) {
                if (!isVisited[dy][dx] && war[dy][dx] == c) {
                    cnt++;
                    isVisited[dy][dx] = true;
                    countSoldier(c, dy, dx);
                }
            }
        }
    }

}