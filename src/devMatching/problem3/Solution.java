package devMatching.problem3;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        solution(8, new int[][] {{0,1}, {1,2}, {2,3}, {4,0}, {5,1}, {6,1}, {7,2}, {7,3}, {4,5}, {5,6}, {6,7}}, 4, 0, 3);
    }

    public static int solution(int n, int[][] edges, int k, int a, int b) {
        int answer = -1;

        List<Integer>[] adjList = new List[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];

            // 양방향 리스트
            adjList[from].add(to);
            adjList[to].add(from);
        }

        dfs(adjList, k, 0, a, b);

        System.out.println(removeList);

        return answer;
    }

    private static List<int[]> removeList = new ArrayList<>();
    private static boolean[] visited = new boolean[8];

    private static void dfs(List<Integer>[] adjList, int k, int cnt, int from, int b) {
        for (int n : adjList[from]) {
            if (cnt == k) {
                if (n != b) removeList.add(new int[] { from, n });
                return;
            }
            if (!visited[n]) {
                visited[n] = true;
                dfs(adjList, k, cnt + 1, n, b);
                visited[n] = false;
            }
        }
    }

}
