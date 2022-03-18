package baekjoon.no17219;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder(); // 출력을 저장하기 위한 StringBuilder
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(tokenizer.nextToken()); // 사이트 주소의 수
		int M = Integer.parseInt(tokenizer.nextToken()); // 찾으려는 사이트 주소의 수
		
		HashMap<String, String> notepad = new HashMap<>();
		for (int i = 0; i < N; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			notepad.put(tokenizer.nextToken(), tokenizer.nextToken());
		}
		
		for (int i = 0; i < M; i++) {
			sb.append(notepad.get(reader.readLine())).append("\n");
		}
		
		System.out.println(sb);
	}
	
}
