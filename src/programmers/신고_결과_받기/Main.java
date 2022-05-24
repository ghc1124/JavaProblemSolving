package programmers.신고_결과_받기;

import java.util.*;

/**
 * 1. 로직
 * - k번 신고 당한 사람은 정지를 먹는다. -> 각 사람별로 횟수를 기억할 변수가 필요하다.
 * - 마지막에 메일을 보내줘야 하므로 누가 그 사람을 신고했는지 기억할 변수가 필요하다.
 * - Map을 사용한다. 사용자 이름을 key, 신고한 사람을 value로 하여 value의 개수에 따라 판별하고, value에 있는 사람들에게 메일을 보낸다!
 * 2. 시간복잡도
 * - Map을 사용할거라 가능할듯
 * 3. 변수
 * - 사람의 수는 최대 1000명. 각 사람의 이름은 최대 길이 10
 * - 중복 데이터는 없다.
 * - 신고 횟수는 최대 200,000 -> 동일 유저에게 여러 번 신고해도 1회로 처리(중요)
 */

public class Main {

    public static void main(String[] args) {
        int[] res = solution(new String[] { "muzi", "frodo", "apeach", "neo" }, new String[] { "muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi" }, 2);
        System.out.println(Arrays.toString(res));
    }

    private static int[] solution(String[] id_list, String[] report, int k) {
        int[] res = new int[id_list.length];

        Map<String, Set<String>> map = new HashMap<>();
        Map<String, Integer> cnt = new LinkedHashMap<>();

        // id_list의 순서대로 값을 출력해야 한다.
        // report는 띄어쓰기로 구분되어 신고자, 피신고자로 들어온다. 피신고자가 key, 신고자가 value다.

        for (int i = 0; i < id_list.length; i++) {
            map.put(id_list[i], new HashSet<>());
            cnt.put(id_list[i], 0);
        }

        StringTokenizer tokenizer = null;

        for (int i = 0; i < report.length; i++) {
            tokenizer = new StringTokenizer(report[i]);
            String from = tokenizer.nextToken();    // 신고자
            String to = tokenizer.nextToken();      // 피신고자
            map.get(to).add(from);
        }

        for (int i = 0; i < id_list.length; i++) {
            if (map.get(id_list[i]).size() >= k) {
                // k번 이상 신고 당한 경우 메일 전송
                for (String name : map.get(id_list[i])) {
                    cnt.put(name, cnt.get(name) + 1);
                }
            }
        }

        int index = 0;

        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            res[index++] = entry.getValue();
        }

        return res;
    }

}
