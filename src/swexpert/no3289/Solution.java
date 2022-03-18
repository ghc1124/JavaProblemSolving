package swexpert.no3289;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	private static int[] parents;
	
	private static void makeSet(int N) {
		parents = new int[N + 1]; // 1-base index
		for (int i = 1; i < N + 1; i++) {
			parents[i] = i;
		}
	}
	
	private static int findSet(int n) {
		if (n == parents[n]) return n; // 현재값이 대표자일 경우
		return parents[n] = findSet(parents[n]); // 대표자 찾은 후 대표자값 업데이트
	}
	
	private static boolean unionSet(int a, int b) {
		int aRoot = findSet(a); // a의 대표자
		int bRoot = findSet(b); // b의 대표자
		
		if (aRoot == bRoot) return false; // 같은 대표자일 경우(같은 집합)
		
		parents[bRoot] = aRoot; // 대표자가 다를 경우 오른쪽 값의 대표자를 왼쪽 값의 대표자로 수정
		return true;
	}
	
	private static int isSameSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		return aRoot == bRoot ? 1 : 0;
	}
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine()); // 테케 개수
		
		for (int i = 0; i < T; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int N = Integer.parseInt(tokenizer.nextToken()); // 수의 개수
			int M = Integer.parseInt(tokenizer.nextToken()); // 연산의 개수
			
			makeSet(N); // 초기 집합 만들기
			
			sb.append("#").append(i + 1).append(" ");
			
			for (int j = 0; j < M; j++) {
				tokenizer = new StringTokenizer(reader.readLine());
				int process = Integer.parseInt(tokenizer.nextToken()); // 연산 종류
				int a = Integer.parseInt(tokenizer.nextToken()); // 왼쪽 수
				int b = Integer.parseInt(tokenizer.nextToken()); // 오른쪽 수
				
				switch (process) {
					case 0:
						unionSet(a, b);
						break;
						
					case 1:
						sb.append(isSameSet(a, b));
						break;
				}
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
