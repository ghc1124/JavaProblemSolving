package baekjoon.no15686;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	private static class House {

		int y; // 행
		int x; // 열

		public House(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}

	/**
	 * ① 치킨집의 위치를 파악한다.(집의 위치와 치킨집의 위치는 모두 알고 있다.)
	 * ② 조합을 통해 경우의 수를 만든다.
	 * ③ 각 집에서 이르는 거리를 측정한다.
	 */

	private static List<House> houseList = new ArrayList<>(); // 집들을 관리하는 리스트
	private static List<House> chickenList = new ArrayList<>(); // 치킨집을 관리하는 리스트
	private static int result = Integer.MAX_VALUE; // 정답 출력용

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		
		int N = Integer.parseInt(tokenizer.nextToken()); // 크기
		int M = Integer.parseInt(tokenizer.nextToken()); // 치킨집 수

		for (int i = 0; i < N; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			for (int j = 0; j < N; j++) {
				int temp = Integer.parseInt(tokenizer.nextToken());
				if (temp == 1) houseList.add(new House(i, j));
				else if (temp == 2) chickenList.add(new House(i, j));
			}
		}

		combination(houseList.size(), chickenList.size(), M, 0, 0, new int[M]);

		System.out.println(result);
	}

	// 조합							전체 크기, 치킨집 개수, 뽑아야 되는 수, 시작 인덱스, 현재 뽑은 수, 뽑은 배열
	private static void combination(int houseCnt, int chicKenCnt, int M, int start, int current, int[] selected) {
		// M개를 다 뽑은 경우
		if (current == M) {
			int localShortest = 0;

			// 전체 집을 돌며 순회
			for (int i = 0; i < houseCnt; i++) {
				House currentHouse = houseList.get(i);
				int shortestChicken = Integer.MAX_VALUE;
				for (int j = 0; j < M; j++) {
					// 치킨집과 집과의 거리를 구함
					House currentChicken = chickenList.get(selected[j]);
					int distance = Math.abs(currentHouse.y - currentChicken.y) + Math.abs(currentHouse.x - currentChicken.x);
					shortestChicken = Math.min(shortestChicken, distance);
				}
				localShortest += shortestChicken;
			}

			result = Math.min(result, localShortest);

			return;
		}

		for (int i = start; i < chicKenCnt; i++) {
			selected[current] = i;
			combination(houseCnt, chicKenCnt, M, i + 1, current + 1, selected);
		}
	}
	
}
