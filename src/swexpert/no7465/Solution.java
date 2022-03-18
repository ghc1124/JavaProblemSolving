package swexpert.no7465;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	private static class Node {
		
		int vertex; // 정점
		Node next; 	// 다음 노드
		
		public Node(int vertex, Node next) {
			this.vertex = vertex;
			this.next = next;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine()); // 테케 개수
		
		for (int i = 0; i < T; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int N = Integer.parseInt(tokenizer.nextToken()); // 노드 개수(사람 수)
			int M = Integer.parseInt(tokenizer.nextToken()); // 간선 개수(아는 사이 수)
			
			Node[] adjList = new Node[N + 1]; // 1-base index
			for (int j = 0; j < M; j++) {
				tokenizer = new StringTokenizer(reader.readLine());
				int from = Integer.parseInt(tokenizer.nextToken()); // 시작 정점
				int to = Integer.parseInt(tokenizer.nextToken());	// 끝 정점
				
				adjList[from] = new Node(to, adjList[from]);		// 인접 리스트 생성
				adjList[to] = new Node(from, adjList[to]);
			}
			
			int result = 0;
			
			boolean[] visited = new boolean[N + 1]; // 1-base index
			for (int j = 1; j < N + 1; j++) {
				if (!visited[j]) {
					dfs(adjList, visited, j);
					result++;
				}
			}
			
			sb.append("#").append(i + 1).append(" ");
			sb.append(result).append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static void dfs(Node[] adjList, boolean[] visited, int current) {
		visited[current] = true;
		
		for (Node node = adjList[current]; node != null; node = node.next) {
			if (!visited[node.vertex]) {
				dfs(adjList, visited, node.vertex);
			}
		}
	}

}
