package swexpert.no1859;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	private static long result;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine()); // 테케 개수

		for (int i = 0; i < T; i++) {
			result = 0;
			int N = Integer.parseInt(reader.readLine()); // 연속된 일수
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int[] days = new int[N];
			for (int j = 0; j < N; j++) {
				days[j] = Integer.parseInt(tokenizer.nextToken());
			}

			process(days, 0, N);

			sb.append("#").append(i + 1).append(" ");
			sb.append(result).append("\n");
		}

		System.out.println(sb);
	}

	// start 포함, end 미포함
	private static void process(int[] days, int start, int end) {
		if (start == end) return;

		int max = Integer.MIN_VALUE;
		int maxIndex = 0;

		int sum = 0;

		for (int i = start; i < end; i++) {
			if (days[i] > max) {
				max = days[i];
				maxIndex = i;
			}
		}

		for (int i = start; i < maxIndex; i++) {
			sum += days[i];
		}

		result += days[maxIndex] * (maxIndex - start) - sum;

		process(days, maxIndex + 1, end);
	}

}
