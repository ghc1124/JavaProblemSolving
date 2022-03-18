package baekjoon.no20299;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        // 입력을 얻기 위한 reader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 출력값 저장용
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine()); // StringTokenizer 설정
        int N = Integer.parseInt(tokenizer.nextToken()); // 신청한 동아리의 수
        int S = Integer.parseInt(tokenizer.nextToken()); // 팀원 3명의 능력 합에 대한 스마트클럽 가입조건
        int M = Integer.parseInt(tokenizer.nextToken()); // 개인 능력치에 대한 스마트클럽 가입조건

        int count = 0; // 가입이 가능한 동아리의 수

        while (N-- > 0) { // 신청한 동아리의 수만큼 반복한다.
            tokenizer = new StringTokenizer(reader.readLine()); // StringTokenizer 설정
            int[] members = new int[3]; // 동아리원들의 능력을 담기 위한 배열
            int sum = 0; // 동아리원들의 능력을 합산하기 위한 변수
            boolean isAccept = true; // 스마트클럽 가입 승낙 여부. true -> 허용
            for (int i = 0; i < members.length; i++) {
                members[i] = Integer.parseInt(tokenizer.nextToken()); // 동아리원들의 점수 가져오기
                if (members[i] < M) { // 만약 한명이라도 동아리원이 기준점 M을 넘지 못하면
                    isAccept = false; // 스마트클럽에 들어갈 수 없다.
                    break; // 반복 종료
                }
                sum += members[i]; // 기준점 M을 통과한 동아리원들의 능력 합을 저장한다.
            }

            // 개인 기준점 M은 통과했으나 전체 기준점 S를 넘지 못한 경우 스마트클럽 가입이 거부된다.
            if (isAccept && sum < S) isAccept = false;

            if (isAccept) { // 모든 조건을 충족한 경우
                count++; // 스마트클럽에 가입한 동아리 횟수 증가
                for (int i = 0; i < members.length; i++) {
                    sb.append(members[i]).append(" "); // 스마트클럽에 가입한 동아리원들의 점수 저장
                }
            }
        }

        System.out.println(count + "\n" + sb); // 최종 출력
    }

}
