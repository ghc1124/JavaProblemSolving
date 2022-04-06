package jungol.no2577;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());    // 접시의 수
        int d = Integer.parseInt(tokenizer.nextToken());    // 초밥의 가짓수
        int k = Integer.parseInt(tokenizer.nextToken());    // 연속 수
        int c = Integer.parseInt(tokenizer.nextToken());    // 쿠폰번호

        int[] dishes = new int[N];  // 초밥 접시
        for (int i = 0; i < N; i++) {
            dishes[i] = Integer.parseInt(reader.readLine());
        }

        int[] sushi = new int[d + 1];   // 슬라이딩 윈도우
        int res = 0;                    // 최댓값
        for (int i = 0; i < k; i++) {   // 제일 처음 k개 보기
            if (sushi[dishes[i]] == 0) res++;
            sushi[dishes[i]]++;
        }

        int cnt = res;

        for (int i = 1; i < N; i++) {   // 마지막 원소까지 반복
            if (cnt >= res) {           // 값 갱신
                if (sushi[c] == 0) {    // 쿠폰에 해당하는 초밥을 안먹은 경우
                    res = cnt + 1;      // 무료 초밥 하나 추가
                } else {
                    res = cnt;          // 쿠폰 무료 초밥이 이미 포함된 경우
                }
            }

            sushi[dishes[i - 1]]--;     // 슬라이딩 윈도우 제일 왼쪽값 빼기
            if (sushi[dishes[i - 1]] == 0) cnt--;           // 뺀 초밥이 유일한 값이었으면은 종류 수 감소

            sushi[dishes[(i + k - 1) % N]]++;
            if (sushi[dishes[(i + k - 1) % N]] == 1) cnt++; // 새로 추가할 초밥이 현재 윈도우 내 처음 등장하는 경우 종류 수 증가
        }

        System.out.println(res);
    }

}
