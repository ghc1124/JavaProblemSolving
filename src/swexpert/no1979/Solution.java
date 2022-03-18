package swexpert.no1979;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine()); // 테케 개수
		
		for (int t = 0; t < T; t++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int N = Integer.parseInt(tokenizer.nextToken()); // 가로, 세로 길이
			int K = Integer.parseInt(tokenizer.nextToken()); // 단어 길이
			
			// 배열 입력
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				tokenizer = new StringTokenizer(reader.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(tokenizer.nextToken());
				}
			}
			
			int cnt = 0;
			int answer = 0;
			
			// 행 탐색
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 1) {
						cnt++;
					} else {
						if (cnt == K) answer++;
						cnt = 0;
					}
				}
				if (cnt == K) answer++;
				cnt = 0;
			}
			
			// 열 탐색
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[j][i] == 1) {
						cnt++;
					} else {
						if (cnt == K) answer++;
						cnt = 0;
					}
				}
				if (cnt == K) answer++;
				cnt = 0;
			}
			
			sb.append("#").append(t + 1).append(" ");
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb);
	}

}
