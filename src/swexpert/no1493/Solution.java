package swexpert.no1493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine()); // 테케 개수
		
		HashMap<Integer, int[]> valueMap = new HashMap<>();
		
		int value = 1;
		
		int[][] arr = new int[501][501];
		for (int i = 1; i < 501; i++) {
			for (int j = 1; j <= i; j++) {
				valueMap.put(value, new int[] { i - j + 1, j });
				arr[i - j + 1][j] = value++;
			}
		}
		
		for (int t = 0; t < T; t++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int p = Integer.parseInt(tokenizer.nextToken());
			int q = Integer.parseInt(tokenizer.nextToken());
			
			int row = valueMap.get(p)[0] + valueMap.get(q)[0];
			int col = valueMap.get(p)[1] + valueMap.get(q)[1];
			
			sb.append("#").append(t + 1).append(" ");
			sb.append(arr[row][col]).append("\n");
		}
		
		System.out.println(sb);
	}

}
