package swexpert.no1940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine()); // 테케 개수
		
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(reader.readLine()); // 명령 수
			int speed = 0;
			int distance = 0;
			for (int j = 0; j < N; j++) {
				StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
				
				switch (Integer.parseInt(tokenizer.nextToken())) {
					case 1: // 가속
						speed += Integer.parseInt(tokenizer.nextToken());
						distance += speed;
						break;
						
					case 2: // 감속
						speed = Math.max(0, speed - Integer.parseInt(tokenizer.nextToken()));
						distance += speed;
						break;
						
					case 0: // 유지
						distance += speed;
						break;
				}
			}
			
			sb.append("#").append(i + 1).append(" ");
			sb.append(distance).append("\n");
		}
		
		System.out.println(sb);
	}

}
