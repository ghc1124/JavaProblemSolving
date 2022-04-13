package swexpert.no4013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    private static int[][] magnet;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());

        for (int t = 0; t < T; t++) {
            int K = Integer.parseInt(reader.readLine());        // 회전 수

            magnet = new int[4][8];
            List<int[]> info = new ArrayList<>(4);  // 각 자석별 정보 저장. 0 -> 시작점, 1-> 2번 인덱스, 2-> 6번 인덱스

            StringTokenizer tokenizer;
            for (int i = 0; i < 4; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < 8; j++) {
                    magnet[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            // 초깃값 저장. 인덱스를 저장
            for (int i = 0; i < 4; i++) {
                int[] curr = new int[3];
                curr[1] = 2;
                curr[2] = 6;

                info.add(curr);
            }

            // 회전. 좌석번호와 방향이 들어온다.
            for (int i = 0; i < K; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                int num = Integer.parseInt(tokenizer.nextToken()) - 1;  // 대상 자석
                int way = Integer.parseInt(tokenizer.nextToken());      // 회전 방향

                info = process(info, num, way);
            }

            int ans = 0;

            for (int i = 0; i < 4; i++) {
                if (magnet[i][info.get(i)[0]] == 1) ans += 1 << i;
            }

            sb.append("#").append(t + 1).append(" ");
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }

    private static List<int[]> process(List<int[]> info, int num, int way) {
        int initial = way;

        List<int[]> res = new ArrayList<>(4);
        res.addAll(info);

        // 왼쪽 자석 처리
        for (int i = num; i > 0; i--) {
            if (magnet[i][info.get(i)[2]] != magnet[i - 1][info.get(i - 1)[1]]) { // 회전처리
                res.set(i - 1, rotate(info.get(i - 1), i - 1, way * -1));
                way *= -1;
            } else break;
        }

        way = initial;

        // 오른쪽 자석 처리
        for (int i = num; i < 3; i++) {
            if (magnet[i][info.get(i)[1]] != magnet[i + 1][info.get(i + 1)[2]]) { // 회전처리
                res.set(i + 1, rotate(info.get(i + 1), i + 1, way * -1));
                way *= -1;
            } else break;
        }

        // 자기 자신 회전
        res.set(num, rotate(info.get(num), num, initial));

        return res;
    }

    private static int[] rotate(int[] target, int num, int way) {
        int[] res = new int[3];

        // 1 -> 시계방향, -1 -> 반시계방향
        if (way > 0) {  // 시계방향 회전
            res[0] = target[0] == 0 ? 7 : target[0] - 1;
            res[1] = target[1] == 0 ? 7 : target[1] - 1;
            res[2] = target[2] == 0 ? 7 : target[2] - 1;
        } else {
            res[0] = target[0] == 7 ? 0 : target[0] + 1;
            res[1] = target[1] == 7 ? 0 : target[1] + 1;
            res[2] = target[2] == 7 ? 0 : target[2] + 1;
        }

        return res;
    }

}
