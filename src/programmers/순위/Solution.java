package programmers.순위;

public class Solution {
	
	private static class Node {
		
		int vertex; // 정점
		Node next; // 다음 노드
		
		public Node(int vertex, Node next) {
			this.vertex = vertex;
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", next=" + next + "]";
		}
		
	}
	
	public static void main(String[] args) {
		int n = 5;
		int[][] results = {
				{ 4, 3 },	
				{ 4, 2 },	
				{ 3, 2 },
				{ 1, 2 },	
				{ 2, 5 },	
		};

		int[][] rowColSum = new int[n + 1][2]; // in, out

		Node[] adjList = new Node[n + 1]; // 1-base index
		for (int i = 0; i < results.length; i++) {
			int from = results[i][0];
			int to = results[i][1];

			adjList[from] = new Node(to, adjList[from]); // 인접 리스트에 추가
		}

		for (int i = 1; i < n + 1; i++) {
			dfs(rowColSum, adjList, new boolean[n + 1], i, n, i);
		}

		int answer = 0;

		for (int i = 1; i < n + 1; i++) {
			if (rowColSum[i][0] + rowColSum[i][1] == n - 1) answer++;
		}

		System.out.println(answer);
	}
	
	private static void dfs(int[][] rowColSum, Node[] adjList, boolean[] visited, int current, int n, int target) {
		visited[current] = true;

		// 열 탐색
		for (Node node = adjList[current]; node != null; node = node.next) {
			if (!visited[node.vertex]) {
				rowColSum[target][1]++; // target 기준 나가는 수 증가
				rowColSum[node.vertex][0]++; // node.vertex 기준 들어오는 수 증가
				dfs(rowColSum, adjList, visited, node.vertex, n, target);
			}
		}
	}
	
}
