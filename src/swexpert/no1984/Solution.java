package swexpert.no1984;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine()); // 테케 개수
		
		for (int t = 0; t < T; t++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int[] nums = new int[10];
			for (int i = 0; i < 10; i++) {
				nums[i] = Integer.parseInt(tokenizer.nextToken());
			}
			
			Arrays.sort(nums);
			
			int sum = 0;
			for (int i = 1; i < 9; i++) {
				sum += nums[i];
			}
			
			sb.append("#").append(t + 1).append(" ");
			sb.append(String.format("%.0f", sum / 8.0)).append("\n");
		}
		
		System.out.println(sb);
	}

}
