package baekjoon.no1991;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static class Node {
		
		char value;
		Node left;
		Node right;
		
		public Node(char value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
		
	}
	
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine()); // 노드의 개수
		
		Node[] tree = new Node[N]; // 0-base index
		// 배열 초기화(일단은 value만 채움. value가 곧 인덱스가 된다.)
		for (int i = 0; i < N; i++) {
			tree[i] = new Node((char) ('A' + i), null, null);
		}
		
		// 노드 연결
		for (int i = 0; i < N; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			char value = tokenizer.nextToken().charAt(0);
			char left = tokenizer.nextToken().charAt(0);
			char right = tokenizer.nextToken().charAt(0);
			
			if (left != '.') tree[value - 'A'].left = tree[left - 'A'];
			if (right != '.') tree[value - 'A'].right = tree[right - 'A'];
		}
		
		// 첫 노드(A)부터 탐색 시작
		dfsPreOrder(tree[0]);
		sb.append("\n");
		dfsInOrder(tree[0]);
		sb.append("\n");
		dfsPostOrder(tree[0]);
		
		System.out.println(sb);
	}
	
	private static void dfsPreOrder(Node node) {
		if (node == null) return;
		
		sb.append(node.value);
		dfsPreOrder(node.left);
		dfsPreOrder(node.right);
	}
	
	private static void dfsInOrder(Node node) {
		if (node == null) return;
		
		dfsInOrder(node.left);
		sb.append(node.value);
		dfsInOrder(node.right);
	}
	
	private static void dfsPostOrder(Node node) {
		if (node == null) return;

		dfsPostOrder(node.left);
		dfsPostOrder(node.right);
		sb.append(node.value);
	}
	
}
