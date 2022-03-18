package baekjoon.no7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int[][] directions = {
			{ -1, 0 }, // 상
			{ 1, 0 }, // 하
			{ 0, -1 }, // 좌
			{ 0, 1 }, // 우
	};

	private static Queue<int[]> tomatoList = new ArrayDeque<>(); // 인덱스 0: 행, 인덱스 1: 열
	private static int[][] tomatoes; // 토마토 정보를 저장하기 위한 배열

	private static int countOne, countZero, countMinusOne; // 1, 0, -1 각각 카운트
	private static int result; // 정답용

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

		int M = Integer.parseInt(tokenizer.nextToken()); // 상자 가로 길이
		int N = Integer.parseInt(tokenizer.nextToken()); // 상자 세로 길이

		tomatoes = new int[N][M];
		for (int i = 0; i < N; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			for (int j = 0; j < M; j++) {
				tomatoes[i][j] = Integer.parseInt(tokenizer.nextToken());

				if (tomatoes[i][j] == 1) {
					tomatoList.offer(new int[] { i, j }); // 익은 토마토 위치 삽입
					countOne++;
				} else if (tomatoes[i][j] == 0)
					countZero++;
				else
					countMinusOne++;
			}
		}

		// 모든 토마토가 다 익었거나, 익은 토마토와 빈 상자로만 구성된 경우 바로 리턴
		if (countOne == N * M || countOne + countMinusOne == N * M) {
			System.out.println(0);
			return;
		}

		while (!tomatoList.isEmpty()) {
			int size = tomatoList.size();
			boolean flag = false;
			while (size-- > 0) {
				if (bfs(tomatoList.poll(), N, M))
					flag = true;
			}

			if (flag)
				result++;
		}

		// 모두 익지 못하는 상황
		if (countOne + countMinusOne != N * M) {
			System.out.println(-1);
			return;
		}

		System.out.println(result);
	}

	private static boolean bfs(int[] code, int N, int M) {
		int y = code[0];
		int x = code[1];

		boolean flag = false;

		for (int i = 0; i < 4; i++) {
			int dy = y + directions[i][0];
			int dx = x + directions[i][1];

			// 유효한 좌표값이고
			if (dy >= 0 && dy < N && dx >= 0 && dx < M) {
				// 익지 않은 토마토일 경우
				if (tomatoes[dy][dx] == 0) {
					tomatoes[dy][dx] = 1; // 토마토가 익음
					countOne++;
					flag = true;
					tomatoList.add(new int[] { dy, dx });
				}
			}
		}

		return flag;
	}

}
