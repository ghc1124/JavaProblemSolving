package baekjoon.no15900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static List<Integer>[] adjList;
    private static boolean[] visited;
    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine()); // 정점 개수. 간선의 수는 N - 1개(이게 홀수, 리프가 홀수가 돼야된다)
        adjList = new List[N + 1]; // 1-based index
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());

            adjList[x].add(y);
            adjList[y].add(x);
        }

        dfs(1, 0);

        System.out.println(result % 2 == 0 ? "No" : "Yes");
    }

    private static void dfs(int num, int sum) {
        visited[num] = true; // 방문 처리

        for (int i = 0; i < adjList[num].size(); i++) {
            if (!visited[adjList[num].get(i)]) {
                visited[adjList[num].get(i)] = true;
                dfs(adjList[num].get(i), sum + 1);
            }
        }

        // dfs를 마친 후 리프 노드일 때만 값을 누적해준다. 리프 노드 -> 인접 리스트의 크기가 1(부모 정보만 가지고 있기 때문에)
        if (adjList[num].size() == 1) result += sum;
    }

}
