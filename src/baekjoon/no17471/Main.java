package baekjoon.no17471;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int[] population;
    private static int[] team;
    private static List<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());    // 구역의 개수
        population = new int[N + 1];
        team = new int[N + 1];

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(tokenizer.nextToken());
        }

        adjList = new List[N + 1];  // 1-base index, 인접리스트
        for (int i = 0; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int cnt = Integer.parseInt(tokenizer.nextToken());
            for (int j = 0; j < cnt; j++) {
                int to = Integer.parseInt(tokenizer.nextToken());
                adjList[i].add(to);
            }
        }

        subset(1, N);

        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }

    private static void subset(int idx, int N) {
        if (idx == N + 1) {     // 마지막 원소까지 모두 고려했다면
            // 연결돼 있는지 확인
            isConnected(N);
            return;
        }

        team[idx] = 1;
        subset(idx + 1, N); // 현재 원소를 고려한 경우
        team[idx] = 0;
        subset(idx + 1, N); // 현재 원소를 고려하지 않은 경우
    }

    private static int sum, res = Integer.MAX_VALUE;

    private static void isConnected(int N) { // subset 메서드에서 처리한 team 배열을 이용하여 처리
        boolean[] visited = new boolean[N + 1];;
        boolean flag = false;

        // 그룹은 2개 -> 0 그룹과 1 그룹. 각각의 그룹에서 하나씩 택한 다음 dfs를 수행하여 모두 연결돼었는지 체크
        for (int i = 1; i <= N; i++) {
            if (team[i] == 1) {
                visited[i] = true;
                dfs(i, 1, visited);
                flag = true;
                break;
            }
        }

        if (!flag) return;

        flag = false;

        for (int i = 1; i <= N; i++) {
            if (team[i] == 0) {
                visited[i] = true;
                dfs(i, 0, visited);
                flag = true;
                break;
            }
        }

        if (!flag) return;

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) return;
        }

        res = Math.min(res, calc(N));
    }

    private static void dfs(int node, int teamNo, boolean[] visited) {
        for (int n : adjList[node]) {
            if (!visited[n] && team[n] == teamNo) {
                visited[n] = true;
                dfs(n, teamNo, visited);
            }
        }
    }

    private static int calc(int N) {
        int sumA = 0, sumB = 0;

        for (int i = 1; i <= N; i++) {
            if (team[i] == 1) sumA += population[i];
            else sumB += population[i];
        }

        return Math.abs(sumA - sumB);
    }

}
