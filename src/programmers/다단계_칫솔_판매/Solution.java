package programmers.다단계_칫솔_판매;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        solution(new String[] {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                 new String[] {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                 new String[] {"young", "john", "tod", "emily", "mary"},
                 new int[] {12, 4, 2, 5, 10});
    }

    private static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // 사람별 번호 부여
        Map<String, Integer> people = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            people.put(enroll[i], i);
        }

        // 부모 노드와 매칭
        Map<String, String> parents = new HashMap<>();
        for (int i = 0; i < referral.length; i++) {
            parents.put(enroll[i], referral[i]);
        }

        // 이익 누적 배열
        int[] profits = new int[enroll.length];

        for (int i = 0; i < seller.length; i++) {
            String person = seller[i];
            int profit = amount[i] * 100;

            while (true) {
                int tenPercent = (int) (profit * 0.1);

                // 현재 자신 처리
                if (tenPercent >= 1) {
                    profits[people.get(person)] += (profit - tenPercent);
                } else {
                    profits[people.get(person)] += profit;
                    break;
                }

                if ((parents.get(person)).equals("-")) break;

                person = parents.get(person);
                profit = tenPercent;
            }
        }

        System.out.println(Arrays.toString(profits));

        return null;
    }

}
