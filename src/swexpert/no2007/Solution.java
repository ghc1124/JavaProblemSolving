package swexpert.no2007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine()); // 테케 개수
		
		for (int t = 0; t < T; t++) {
			char[] temp = reader.readLine().toCharArray();
			int length = 0;
			char start = temp[0];
			for (int i = 1, size = temp.length; i < size - 1; i++) {
				if (temp[i] == start) {
					if (temp[1] == temp[i + 1]) {
						length = i;
						break;
					}
				}
			}
			
			sb.append("#").append(t + 1).append(" ");
			sb.append(length).append("\n");
		}
		
		System.out.println(sb);
	}

}
