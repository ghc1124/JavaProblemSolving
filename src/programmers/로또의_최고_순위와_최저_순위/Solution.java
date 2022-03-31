package programmers.로또의_최고_순위와_최저_순위;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        solution(new int[] {0, 0, 0, 0, 0, 0}, new int[] {38, 19, 20, 40, 15, 25});
    }

    private static void solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 6; i++) {
            set.add(win_nums[i]);
        }

        int zeroCnt = 0;
        int winCnt = 0;

        for (int i = 0; i < 6; i++) {
            if (lottos[i] == 0) zeroCnt++;
            else {
                if (set.contains(lottos[i])) winCnt++;
            }
        }

        int max = winCnt + zeroCnt;

        answer[0] = (7 - max) > 5 ? 6 : (7 - max);
        answer[1] = (7 - winCnt) > 5 ? 6 : (7 - winCnt);

        System.out.println(Arrays.toString(answer));
    }

}
