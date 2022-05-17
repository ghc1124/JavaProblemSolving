package softeer.전광판;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private static Map<Integer, int[]> map;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());    // 테스트케이스 개수

        map = new HashMap<>();  // 각 숫자별 켜진 위치
        map.put(0, new int[] { 1, 1, 1, 1, 1, 1, 0 });
        map.put(1, new int[] { 0, 1, 1, 0, 0, 0, 0 });
        map.put(2, new int[] { 1, 1, 0, 1, 1, 0, 1 });
        map.put(3, new int[] { 1, 1, 1, 1, 0, 0, 1 });
        map.put(4, new int[] { 0, 1, 1, 0, 0, 1, 1 });
        map.put(5, new int[] { 1, 0, 1, 1, 0, 1, 1 });
        map.put(6, new int[] { 1, 0, 1, 1, 1, 1, 1 });
        map.put(7, new int[] { 1, 1, 1, 0, 0, 1, 0 });
        map.put(8, new int[] { 1, 1, 1, 1, 1, 1, 1 });
        map.put(9, new int[] { 1, 1, 1, 1, 0, 1, 1 });

        for (int t = 0; t < T; t++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

            int A = Integer.parseInt(tokenizer.nextToken());    // 원래 숫자
            int B = Integer.parseInt(tokenizer.nextToken());    // 바뀔 숫자

            int[] arrA = new int[5];    // 숫자 쪼개기
            int[] arrB = new int[5];

            Arrays.fill(arrA, -1);  // 아예 안켜진 숫자 -> -1로 두기
            Arrays.fill(arrB, -1);

            for (int i = 0; i < 5; i++) {
                arrA[i] = A % 10;   // 숫자 한자리씩 쪼갠다. 1의 자리수부터 역순으로 쪼개서 자리수 상관없이 항상 비교할 수 있도록 한다.
                A /= 10;
                if (A == 0) break;
            }

            for (int i = 0; i < 5; i++) {
                arrB[i] = B % 10;
                B /= 10;
                if (B == 0) break;
            }

            int res = 0;    // 전체 횟수를 기억하기 위한 변수

            for (int i = 0; i < 5; i++) {
                if (arrA[i] != arrB[i]) {   // 만약 두 수가 다른 경우,
                    if (arrA[i] == -1) {    // 두 수가 다른데 어느 한쪽이 -1 즉, 안켜진 경우라면 그냥 단순히 나머지 한쪽 켜기만 하면 됨 -> 1의 개수의 합을 구한다.
                        res += sum(arrB[i]);
                    } else if (arrB[i] == -1) {
                        res += sum(arrA[i]);
                    } else {    // 둘 다 -1이 아닌 경우 각 자리수를 비교하여 다른 수만큼 더한다.
                        res += calcDiff(arrA[i], arrB[i]);
                    }
                }
            }

            sb.append(res).append("\n");
        }

        System.out.println(sb);
    }

    private static int calcDiff(int a, int b) {
        int[] arrA = map.get(a);
        int[] arrB = map.get(b);

        int cnt = 0;

        for (int i = 0; i < 7; i++) {
            if (arrA[i] != arrB[i]) {
                cnt++;
            }
        }

        return cnt;
    }

    private static int sum(int a) {
        int[] target = map.get(a);

        int cnt = 0;

        for (int i = 0; i < 7; i++) {
            cnt += target[i];
        }

        return cnt;
    }

}
