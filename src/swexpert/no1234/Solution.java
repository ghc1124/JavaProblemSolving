package swexpert.no1234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 10; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int N = Integer.parseInt(tokenizer.nextToken());
			
			ArrayDeque<Character> stack = new ArrayDeque<>();
			
			char[] temp = tokenizer.nextToken().toCharArray();
			stack.push(temp[0]);
			
			for (int j = 1, size = temp.length; j < size; j++) {
				if (!stack.isEmpty() && stack.peek() == temp[j]) stack.pop();
				else stack.push(temp[j]);
			}
			
			sb.append("#").append(i + 1).append(" ");
			while (!stack.isEmpty()) sb.append(stack.pollLast());
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
