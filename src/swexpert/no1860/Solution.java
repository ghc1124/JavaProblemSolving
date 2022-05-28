package swexpert.no1860;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 로직
 * 1) 가장 늦게 도착하는 손님이 도착하는 시간을 M으로 나눈 몫의 크기로 배열을 만든다.
 * 2) 각 배열은 인덱스 1부터 K로 채운다.
 * 3) 손님 배열을 탐색하며 손님이 도착한 시간을 M으로 나눈 몫의 인덱스 크기를 감소시키는데, 이때 불가능하면 Impossible
 * 2. 시간복잡도
 * 1) 가능할듯
 * 3. 변수 범위
 * 1) int로 처리 가능
 */

public class Solution {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

            int N = Integer.parseInt(tokenizer.nextToken());    // 인원수
            int M = Integer.parseInt(tokenizer.nextToken());    // 쿨타임
            int K = Integer.parseInt(tokenizer.nextToken());    // 붕어빵의 수

            int[] customer = new int[N];
            int maxTime = 0;

            tokenizer = new StringTokenizer(reader.readLine());

            for (int i = 0; i < N; i++) {
                customer[i] = Integer.parseInt(tokenizer.nextToken());
                maxTime = customer[i] > maxTime ? customer[i] : maxTime;
            }

            String ans = "Possible";

            int[] fishBread = new int[maxTime / M + 1];
            for (int i = 1; i < fishBread.length; i++) {
                fishBread[i] += fishBread[i - 1] + K;
            }

            for (int i = 0; i < N; i++) {
                int index = customer[i] / M;
                if (fishBread[index] > 0) {
                    fishBread[index]--;
                    if (index < fishBread.length - 1) {
                        reduce(fishBread, index + 1, fishBread.length);
                    }
                } else {
                    ans = "Impossible";
                    break;
                }
            }

            sb.append("#").append(t + 1).append(" ");
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }

    private static void reduce(int[] target, int from, int to) {
        for (int i = from; i < to; i++) {
            target[i]--;
        }
    }

}
