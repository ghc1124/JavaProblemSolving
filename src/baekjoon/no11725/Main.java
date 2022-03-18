package baekjoon.no11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static List<Integer>[] nodeList;
    private static int[] parents;
    private static boolean[] decision;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine()); // 노드의 개수

        parents = new int[N + 1]; // 1-base index
        parents[1] = 1;

        decision = new boolean[N + 1]; // 부모가 확정됐는지 여부
        decision[1] = true; // 1번은 루트 노드이므로 부모가 확정됨

        nodeList = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            nodeList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());

            if (decision[x]) { // x의 부모가 확정된 경우
                decision[y] = true;
                parents[y] = x;
                dfs(y);
            } else if (decision[y]) { // y의 부모가 확정된 경우
                decision[x] = true;
                parents[x] = y;
                dfs(x);
            } else {
                nodeList[x].add(y);
                nodeList[y].add(x);
            }
        }

        for (int i = 2; i <= N; i++) {
            sb.append(parents[i]).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int num) {
        for (int i = 0, size = nodeList[num].size(); i < size; i++) {
            if (!decision[nodeList[num].get(i)]) {
                decision[nodeList[num].get(i)] = true;
                parents[nodeList[num].get(i)] = num;
                dfs(nodeList[num].get(i));
            }
        }
    }

}
