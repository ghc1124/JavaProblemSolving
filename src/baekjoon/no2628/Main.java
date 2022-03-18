package baekjoon.no2628;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int hori = Integer.parseInt(tokenizer.nextToken()); // 가로
        int vert = Integer.parseInt(tokenizer.nextToken()); // 세로

        List<Integer> horiCut = new ArrayList<>();
        List<Integer> vertCut = new ArrayList<>();

        int N = Integer.parseInt(reader.readLine()); // 자르는 점선의 개수
        for (int i = 0; i < N; i++) { // 가로, 세로로 자르는 라인수를 각각 맞게 저장
            tokenizer = new StringTokenizer(reader.readLine());
            if (Integer.parseInt(tokenizer.nextToken()) == 0) horiCut.add(Integer.parseInt(tokenizer.nextToken()));
            else vertCut.add(Integer.parseInt(tokenizer.nextToken()));
        }

        // 리스트 정렬
        Collections.sort(horiCut);
        Collections.sort(vertCut);

        int result = 0;

        int row = 0; // 직전 행
        for (int i = 0; i < horiCut.size(); i++) {
            int col = 0; // 직전 열
            for (int j = 0; j < vertCut.size(); j++) {
                int area = (horiCut.get(i) - row) * (vertCut.get(j) - col);
                col = vertCut.get(j);
                result = Math.max(result, area);
            }

            if (vertCut.size() > 0) {
                // 마지막 열 처리
                int area = (horiCut.get(i) - row) * (hori - vertCut.get(vertCut.size() - 1));
                result = Math.max(result, area);
            }

            // 세로로 안자르는 경우
            if (vertCut.size() == 0) {
                int area = (horiCut.get(i) - row) * hori;
                result = Math.max(result, area);
            }

            row = horiCut.get(i);
        }

        if (horiCut.size() > 0) {
            // 마지막 행 처리
            int col = 0; // 직전 열
            for (int j = 0; j < vertCut.size(); j++) {
                int area = (vert - horiCut.get(horiCut.size() - 1)) * (vertCut.get(j) - col);
                col = vertCut.get(j);
                result = Math.max(result, area);
            }

            if (vertCut.size() > 0) {
                // 마지막 열 처리
                int area = (vert - horiCut.get(horiCut.size() - 1)) * (hori - vertCut.get(vertCut.size() - 1));
                result = Math.max(result, area);
            }

            // 세로로 안자르는 경우
            if (vertCut.size() == 0) {
                int area = (vert - horiCut.get(horiCut.size() - 1)) * hori;
                result = Math.max(result, area);
            }
        }

        // 가로로 안자르는 경우
        if (horiCut.size() == 0) {
            int col = 0; // 직전 열
            for (int j = 0; j < vertCut.size(); j++) {
                int area = vert * (vertCut.get(j) - col);
                col = vertCut.get(j);
                result = Math.max(result, area);
            }

            if (vertCut.size() > 0) {
                // 마지막 열 처리
                int area = vert * (hori - vertCut.get(vertCut.size() - 1));
                result = Math.max(result, area);
            }
        }

        System.out.println(result);
    }

}
