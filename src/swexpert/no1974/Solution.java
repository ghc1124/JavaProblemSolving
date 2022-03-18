package swexpert.no1974;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine()); // 테케 개수
		
		for (int t = 0; t < T; t++) {
			int[][] sudoku = new int[9][9];
			boolean flag = true; // 스도쿠 성립
			for (int i = 0; i < 9; i++) {
				String[] temp = reader.readLine().split(" ");
				for (int j = 0; j < 9; j++) {
					sudoku[i][j] = Integer.parseInt(temp[j]);
				}
			}
			
			// 행 검증
			Outer: for (int i = 0; i < 9; i++) {
				int[] check = new int[10]; // 1-base index
				for (int j = 0; j < 9; j++) {
					if (check[sudoku[i][j]] == 0) check[sudoku[i][j]]++;
					else {
						flag = false; // 성립하지 않음
						break Outer;
					}
				}
			}
			
			// 열 검증
			if (flag) {
				Outer: for (int i = 0; i < 9; i++) {
					int[] check = new int[10]; // 1-base index
					for (int j = 0; j < 9; j++) {
						if (check[sudoku[j][i]] == 0) check[sudoku[j][i]]++;
						else {
							flag = false; // 성립하지 않음
							break Outer;
						}
					}
				}
			}
			
			// 3*3 검증
			if (flag) {
				Outer: for (int i = 0; i <= 6; i += 3) {
					for (int j = 0; j <= 6; j += 3) {
						int[] check = new int[10]; // 1-base index
						for (int k = i; k < 3; k++) {
							for (int l = j; l < 3; l++) {
								if (check[sudoku[k][l]] == 0) check[sudoku[k][l]]++;
								else {
									flag = false; // 성립하지 않음
									break Outer;
								}
							}
						}
					}
				}
			}
			
			sb.append("#").append(t + 1).append(" ");
			sb.append(flag ? "1" : "0").append("\n");
		}
		
		System.out.println(sb);
	}

}
