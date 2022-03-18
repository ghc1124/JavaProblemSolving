package programmers.가장_먼_노드;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        // int n, int[][] edge
        int n = 6;
        int[][] edge = {
                { 3, 6 },
                { 4, 3 },
                { 3, 2 },
                { 1, 3 },
                { 1, 2 },
                { 2, 4 },
                { 5, 2 },
        };

        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < edge.length; i++) {
            adjacencyList.get(edge[i][0]).add(edge[i][1]);
            adjacencyList.get(edge[i][1]).add(edge[i][0]);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] flag = new boolean[n + 1];

        queue.offer(1);

        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            count = 0;
            while (size-- > 0) {
                int target = queue.poll();
                flag[target] = true;
                count++;
                // 열만 보면 됨
                List<Integer> tempList = adjacencyList.get(target);
                for (int num : tempList) {
                    if (!flag[num]) {
                        queue.offer(num);
                        flag[num] = true;
                    }
                }
            }
        }

        System.out.println(count);
    }

}
