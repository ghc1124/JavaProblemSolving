package swexpert.no5643;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    private static List<Integer>[] adjList;
    private static int[][] students;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(reader.readLine());        // 테스트케이스 개수

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(reader.readLine());    // 학생들의 수
            students = new int[N + 1][2];               // 0 -> 들어오는 수, 1 -> 나가는 수
            int M = Integer.parseInt(reader.readLine());    // 비교 횟수

            adjList = new List[N + 1];      // 1-base index, 인접리스트
            for (int i = 0; i <= N; i++) {
                adjList[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                int from = Integer.parseInt(tokenizer.nextToken());
                int to = Integer.parseInt(tokenizer.nextToken());
                adjList[from].add(to);
            }

            for (int i = 1; i <= N; i++) {
                dfs(i, new boolean[N + 1], i);
            }

            int cnt = 0;

            for (int i = 1; i <= N; i++) {
                if (students[i][0] + students[i][1] == N - 1) cnt++;
            }

            sb.append("#").append(t + 1).append(" ");
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int node, boolean[] visited, int origin) {
        visited[node] = true;

        for (int n : adjList[node]) {
            if (!visited[n]) {
                students[origin][1]++;
                students[n][0]++;
                dfs(n, visited, origin);
            }
        }
    }

}
