package baekjoon.no10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		char[] temp = reader.readLine().toCharArray();
		
		int pipeCnt = 0;
		int answer = 0;
		
		for (int i = 1, size = temp.length; i < size; i++) {
			if (temp[i] == '(') {
				if (temp[i - 1] == '(') pipeCnt++; // 파이프의 시작
			} else if (temp[i] == ')') {
				if (temp[i - 1] == ')') { // 파이프의 끝
					answer += 1;
					pipeCnt--;
				}
				else answer += pipeCnt; // 레이저 컷
			}
		}
		
		System.out.println(answer);
	}

}
