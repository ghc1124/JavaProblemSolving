package baekjoon.no1068;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine()); // 노드의 개수

        List<Integer>[] adjList = new List[N];

        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }

        int index = 0;
        int root = 0;

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        while (tokenizer.hasMoreTokens()) {
            int curr = Integer.parseInt(tokenizer.nextToken());

            if (curr == -1) {
                root = index++;
                continue;
            }

            adjList[curr].add(index++);
        }

        int remove = Integer.parseInt(reader.readLine());

        if (root != remove) dfs(adjList, root, remove);

        System.out.println(result);
    }

    private static void dfs(List<Integer>[] adjList, int curr, int remove) {
        boolean flag = false;

        for (int n : adjList[curr]) {
            if (n == remove) continue;

            flag = true;

            dfs(adjList, n, remove);
        }

        if (!flag) result++;
    }

}
