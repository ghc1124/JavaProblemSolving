package swexpert.no2005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine()); // 테캐 개수
		
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(reader.readLine()); // 삼각형 크기 N
			
			int end = 0;
			
			int[][] arr = new int[N][N];
			arr[0][end++] = 1;
			
			for (int i = 1; i < N; i++) {
				arr[i][0] = arr[i][end] = 1;
				for (int j = 1; j < end; j++) {
					arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
				}
				end++;
			}
			
			sb.append("#").append(t + 1).append("\n");
			for (int i = 0; i < N; i++) {
				if (arr[i][0] == 0) break;
				for (int j = 0; j < N; j++) {
					if (arr[i][j] != 0) sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		
		System.out.println(sb);
	}

}
