package baekjoon.no11729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());    // 원판의 개수

        hanoi(N, 1, 2, 3);

        System.out.println(cnt + "\n" + sb.toString());
    }

    private static void hanoi(int n, int left, int center, int right) {
        if (n == 0) return;

        /**
         * 원판이 2개인 상황을 가정해보자. 가장 밑이 n번 원판(2번), 그 위에는 n-1번(1번)이 위치하고 있다.
         * 먼저, 1번 원판을 가운데 기둥으로 옮긴다. 가운데 기둥을 목적지 삼는다.
         * 그 다음, 2번 원판을 목적지 기둥으로 옮기고, 1번 원판을 목적지로 옮긴다.
         */
        hanoi(n - 1, left, right, center);  //
        sb.append(left).append(" ").append(right).append("\n");
        cnt++;
        hanoi(n - 1, center, left, right);
    }

}
