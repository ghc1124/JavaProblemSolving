package devMatching.problem1;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        solution(new int[][] {{0,5,2,4,1}, {5,0,3,9,6}, {2,3,0,6,3}, {4,9,6,0,3}, {1,6,3,3,0}});
    }

    public static int[][] solution(int[][] dist) {
        int[][] answer = new int[2][dist.length];

        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < dist.length; i++) {
            map.put(dist[0][i], i);
        }

        List<Integer> list = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(entry.getValue());
        }

        for (int i = 2; i < list.size(); i++) {
            int dist1 = dist[0][list.get(i - 1)];
            int dist2 = dist[0][list.get(i)];

            if (Math.abs(dist1 - dist2) != dist[list.get(i)][list.get(i - 1)]) {
                int temp = list.get(i);
                list.remove(i);
                list.add(0, temp);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            answer[0][i] = list.get(i);
        }

        for (int i = 0; i < list.size(); i++) {
            answer[1][i] = list.get(list.size() - 1 - i);
        }

        return answer;
    }

}
