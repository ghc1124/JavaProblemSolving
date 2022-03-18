package baekjoon.no16236;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int[][] directions = {
			{ -1, 0 },	// 상
			{ 1, 0 },	// 하
			{ 0, -1 },	// 좌
			{ 0, 1 },	// 우
	};
	
	private static int sharkSize = 2; 	// 상어 크기
	private static int currentEat = 0; 	// 상어 크기 성장 유무를 판별하기 위한 변수
	private static List<Fish> feedList = new ArrayList<>(); // 먹이를 저장하는 리스트
	private static int result = 0; // 결과값을 저장하기 위한 변수
	
	private static class Fish implements Comparable<Fish> {
		
		int y;
		int x;
		int dist;
		
		public Fish(int y, int x, int dist) {
			this.y = y;
			this.x = x;
			this.dist = dist;
		}

		@Override
		public int compareTo(Fish o) {
			if (this.dist == o.dist) {
				if (this.y == o.y) {
					// 행이 같을 경우 열 기준 오름차순
					return this.x - this.x;
				} else {
					// 거리가 같을 경우 행 기준 오름차순
					return this.y - o.y;
				}
			} else {
				// 거리기준 오름차순
				return this.dist - o.dist;
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine()); // 공간의 크기
		
		Fish shark = null;
		
		// 초기 배열 설정
		int[][] fishes = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			for (int j = 0; j < N; j++) {
				fishes[i][j] = Integer.parseInt(tokenizer.nextToken());
				// 상어 위치 찾기
				if (fishes[i][j] == 9) {
					shark = new Fish(i, j, 0);
					fishes[i][j] = 0;
				}
			}
		}
		
		bfs(fishes, shark, N);
		
		System.out.println(result);
	}
	
	private static void bfs(int[][] fishes, Fish shark, int N) {
		boolean[][] visited = new boolean[N][N];
		Queue<Fish> queue = new ArrayDeque<>();
		queue.offer(shark);
		visited[shark.y][shark.x] = true; // 현재 위치 방문 처리
		
		while (!queue.isEmpty()) {
			Fish current = queue.poll();
			int currentDist = current.dist; // 현재 위치까지 이동한 거리
			
			for (int i = 0; i < 4; i++) {
				int dy = current.y + directions[i][0]; // 행
				int dx = current.x + directions[i][1]; // 열
				
				// 유효 인덱스이고
				if (dy >= 0 && dy < N && dx >= 0 && dx < N) {
					// 아직 탐색하지 않은 곳이고
					if (!visited[dy][dx]) {
						// 상어가 먹을 수 있는 물고기인 경우
						if (fishes[dy][dx] != 0 && fishes[dy][dx] < sharkSize) {
							feedList.add(new Fish(dy, dx, currentDist + 1)); // 먹이 리스트에 추가
							queue.offer(new Fish(dy, dx, currentDist + 1));  // 탐색 큐에 추가
							visited[dy][dx] = true;
						}
						
						// 비어있거나 지나갈수만 있는 물고기인 경우
						if (fishes[dy][dx] == 0 || fishes[dy][dx] == sharkSize) {
							queue.offer(new Fish(dy, dx, currentDist + 1));
							visited[dy][dx] = true;
						}
					}
				}
			}
		}
		
		// 먹을 수 있는 먹이가 있는 경우 - 한번에 하나의 물고기만 먹는다
		if (!feedList.isEmpty()) {
			Collections.sort(feedList); // 먹이 정렬
			
			Fish eatTarget = feedList.get(0); // 가장 우선순위가 높은 물고기 먼저 먹음(가깝고, 가장 위쪽에 가장 왼쪽)
			shark.y = eatTarget.y; // 먹이의 위치로 상어 위치 이동
			shark.x = eatTarget.x;
			fishes[shark.y][shark.x] = 0; // 먹이를 먹은 위치를 빈 곳으로 만듦
			
			if (++currentEat == sharkSize) {
				sharkSize++; // 상어의 크기와 같은 횟수를 먹으면 상어 크기 증가
				currentEat = 0;
			}
			
			result += eatTarget.dist; // dist 변수에 해당 먹이까지의 거리 정보를 가지고 있음
			
			feedList.clear();
		} else return;
		
		bfs(fishes, shark, N);
	}

}
