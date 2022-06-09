package baekjoon.no11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static List<Integer>[] adjList;
    private static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());    // 정점의 개수
        int M = Integer.parseInt(tokenizer.nextToken());    // 간선의 개수

        adjList = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(tokenizer.nextToken()); // 점1
            int to = Integer.parseInt(tokenizer.nextToken());   // 점2

            // 무향 그래프이므로 양방향이다.
            adjList[from].add(to);
            adjList[to].add(from);
        }

        isVisited = new boolean[N + 1];   // 각 정점의 방문처리

        int cnt = 0;

        for (int i = 1; i <= N; i++) {
            if (!isVisited[i]) {
                cnt++;
                dfs(i);
            }
        }

        System.out.println(cnt);
    }

    private static void dfs(int n) {
        for (int x : adjList[n]) {
            if (!isVisited[x]) {
                isVisited[x] = true;
                dfs(x);
            }
        }
    }

}
