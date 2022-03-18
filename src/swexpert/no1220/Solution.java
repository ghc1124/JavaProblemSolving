package swexpert.no1220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 0; t < 10; t++) {
			int N = Integer.parseInt(reader.readLine()); // 정사각형 한 변의 길이
			
			// 배열 채우기
			int[][] arr = new int[100][100];
			for (int i = 0; i < 100; i++) {
				StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(tokenizer.nextToken());
				}
			}
			
			int answer = 0;
			
			for (int i = 0; i < 100; i++) {
				boolean flag = false;
				for (int j = 0; j < 100; j++) {
					if (arr[j][i] == 1) flag = true; // N극을 만남
					if (arr[j][i] == 2 && flag) {
						answer++;
						flag = false;
					}
				}
			}
			
			sb.append("#").append(t + 1).append(" ");
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb);
	}

}
