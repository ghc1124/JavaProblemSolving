package baekjoon.no13305;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());    // 도시의 개수

        long[] road = new long[N - 1];
        long[] city = new long[N];
        long[] dist = new long[N];

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N - 1; i++) {
            road[i] = Long.parseLong(tokenizer.nextToken());
        }

        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            city[i] = Long.parseLong(tokenizer.nextToken());
        }

        dist[0] = 0;
        dist[1] = city[0] * road[0];  // 두 값은 고정

        long minCity = Math.min(city[0], city[1]);

        for (int i = 1; i < N - 1; i++) {
            if (minCity > city[i]) minCity = city[i];
            dist[i + 1] = dist[i] + road[i] * minCity;
        }

        System.out.println(dist[N - 1]);
    }

}
