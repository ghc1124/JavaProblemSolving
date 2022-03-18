package baekjoon.no10026;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	private static int[][] directions = {
			{ -1, 0 },	// 상
			{ 1, 0 },	// 하
			{ 0, -1 },	// 좌
			{ 0, 1 },	// 우
	};
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine()); // 크기
		
		// 초기 배열 설정
		char[][] rgb = new char[N][N];
		for (int i = 0; i < N; i++) {
			rgb[i] = reader.readLine().toCharArray();
		}
		
		boolean[][] visitedNormal = new boolean[N][N]; 	// 색약이 아닌 사람 방문 기록
		boolean[][] visitedRG = new boolean[N][N];		// 색약인 사람 방문 기록
		
		int normalCnt = 0; 	// 색약 아닌 사람 구역 수
		int rgCnt = 0;		// 색약인 사람 구역 수
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visitedNormal[i][j]) {
					dfs(rgb, visitedNormal, i, j, N, rgb[i][j] + "");
					normalCnt++;
				}
				
				if (!visitedRG[i][j]) {
					if (rgb[i][j] == 'R' || rgb[i][j] == 'G') dfs(rgb, visitedRG, i, j, N, "RG");
					else dfs(rgb, visitedRG, i, j, N, "B");
					rgCnt++;
				}
			}
		}		
		
		System.out.println(normalCnt + " " + rgCnt);
	}
	
	private static void dfs(char[][] rgb, boolean[][] visited, int row, int col, int N, String target) {
		visited[row][col] = true;
		
		for (int i = 0; i < 4; i++) {
			int dy = row + directions[i][0];
			int dx = col + directions[i][1];
			
			// 유효 범위 내 인덱스이고
			if (dy >= 0 && dy < N && dx >= 0 && dx < N) {
				// 아직 방문하지 않았으며 찾는 char 값과 같은 값인 경우 재귀
				if (!visited[dy][dx] && target.contains((rgb[dy][dx] + ""))) dfs(rgb, visited, dy, dx, N, target);
			}
		}
	}

}
