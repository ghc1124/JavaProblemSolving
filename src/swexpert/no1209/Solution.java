package swexpert.no1209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 0; t < 10; t++) {
			int N = Integer.parseInt(reader.readLine()); // 테스트 케이스 번호
			
			// 배열 채우기
			int[][] arr = new int[100][100];
			for (int i = 0; i < 100; i++) {
				StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(tokenizer.nextToken());
				}
			}
			
			int diaLeftSum = 0, diaRightSum = 0;
			int answer = 0;
			
			for (int i = 0; i < 100; i++) {
				int rowSum = 0, colSum = 0;
				for (int j = 0; j < 100; j++) {
					rowSum += arr[i][j];
					colSum += arr[j][i];
				}
				
				answer = Math.max(answer, Math.max(rowSum, colSum));
				
				diaLeftSum += arr[i][i];
				diaRightSum += arr[i][100 - i - 1];
			}
			
			answer = Math.max(answer, Math.max(diaLeftSum, diaRightSum));
			
			sb.append("#").append(N).append(" ");
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb);
	}

}
