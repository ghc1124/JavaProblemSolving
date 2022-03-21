package baekjoon.no1717;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] numArr; // 대표자를 담은 집합

    // 기본 대표자 설정 -> 자기 자신
    private static void makeSet(int n) {
        numArr = new int[n + 1]; // 0부터 n까지 생성
        for (int i = 0; i <= n; i++) {
            numArr[i] = i;
        }
    }

    private static boolean unionSet(int x, int y) {
        int parentX = findSet(x); // x 부모
        int parentY = findSet(y); // y 부모

        if (parentX == parentY) return false; // 이미 같은 집합

        numArr[parentY] = parentX; // y의 대표자를 x의 대표자로 설정 -> x의 집합에 y 추가

        return true;
    }

    // 대표자 찾기
    private static int findSet(int target) {
        if (numArr[target] == target) return target; // 해당 인덱스의 값이 인덱스와 같은 경우 -> 대표자

        return numArr[target] = findSet(numArr[target]); // Path Compression
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken()); // N 까지의 수
        int M = Integer.parseInt(tokenizer.nextToken()); // 연산의 수

        makeSet(N);

        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int command = Integer.parseInt(tokenizer.nextToken());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());

            switch (command) {
                case 0:
                    unionSet(a, b);
                    break;

                case 1:
                    sb.append(findSet(a) == findSet(b) ? "YES" : "NO").append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }

}