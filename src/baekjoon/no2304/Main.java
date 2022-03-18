package baekjoon.no2304;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static class Pole implements Comparable<Pole> {

        int x;
        int y;

        public Pole(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pole o) {
            return this.x - o.x;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine()); // 기둥의 개수

        List<Pole> poleList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            poleList.add(new Pole(x, y));
        }

        Collections.sort(poleList);

        int maxY = 0; // 가장 높은 기둥
        int index = 0; // 가장 높은 기둥의 인덱스

        // 가장 높은 기둥 찾기
        for (int i = 0, size = poleList.size(); i < size; i++) {
            if (poleList.get(i).y > maxY) {
                maxY = poleList.get(i).y;
                index = i;
            }
        }

        int area = 0; // 넓이를 저장하는 변수

        int leftY = poleList.get(0).y; // 왼쪽 끝 기둥
        int leftX = poleList.get(0).x; // x 좌표 위치

        for (int i = 1; i <= index; i++) {
            if (leftY <= poleList.get(i).y) {
                area += leftY * (poleList.get(i).x - leftX);
                leftY = poleList.get(i).y;
                leftX = poleList.get(i).x;
            }
        }

        int rightY = poleList.get(poleList.size() - 1).y; // 오른쪽 끝 기둥
        int rightX = poleList.get(poleList.size() - 1).x; // x 좌표 위치

        for (int i = poleList.size() - 2; i >= index; i--) {
            if (rightY <= poleList.get(i).y) {
                area += rightY * (rightX - poleList.get(i).x);
                rightY = poleList.get(i).y;
                rightX = poleList.get(i).x;
            }
        }

        area += maxY;

        System.out.println(area);
    }

}
