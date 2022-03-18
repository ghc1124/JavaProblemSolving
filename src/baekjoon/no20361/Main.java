package baekjoon.no20361;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        // 입력을 얻기 위한 reader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 종이컵의 수, 간식 위치, 바꾸는 횟수를 얻기 위한 StringTokenizer
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken()); // 종이컵의 수
        int X = Integer.parseInt(tokenizer.nextToken()); // 간식 위치
        int K = Integer.parseInt(tokenizer.nextToken()); // 위치를 바꾼 횟수

        int[] paperCup = new int[N]; // 종이컵 정보 배열
        for (int i = 0; i < paperCup.length; i++) {
            paperCup[i] = i + 1; // 1부터 N까지 수를 채워넣는다.
        }

        // K개의 줄에서 바꾼 두 컵의 위치를 받아온다.
        for (int i = 0; i < K; i++) {
            tokenizer = new StringTokenizer(reader.readLine()); // StringTokenizer 설정
            int from = Integer.parseInt(tokenizer.nextToken()) - 1; // 시작(0-인덱스이므로 -1)
            int to = Integer.parseInt(tokenizer.nextToken()) - 1;	// 시작(0-인덱스이므로 -1)
            swap(paperCup, from, to); // 두 컵의 위치 교환
        }

        for (int i = 0; i < paperCup.length; i++) {
            if (paperCup[i] == X) { // 간식을 찾을 경우(1부터 N까지 처음에 넣었으므로 X를 찾으면 된다.)
                System.out.println(i + 1);
                break;
            }
        }
    }

    // 배열의 두 원소를 교환하는 메서드
    private static void swap(int[] target, int from, int to) {
        int temp = target[from]; 	// from 인덱스의 값 저장
        target[from] = target[to];	// to 인덱스의 값을 from 인덱스에 저장
        target[to] = temp;			// to 인덱스에 미리 저장해둔 temp 저장
    }

}