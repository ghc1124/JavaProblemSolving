package baekjoon.no1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	private static class Node implements Comparable<Node> {

		int vertex;
		int distance;

		public Node(int vertex, int distance) {
			this.vertex = vertex;
			this.distance = distance;
		}

		@Override
		public int compareTo(Node o) {
			return this.distance - o.distance;
		}

	}

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int V = Integer.parseInt(tokenizer.nextToken()); // 정점 개수
		int E = Integer.parseInt(tokenizer.nextToken()); // 간선 개수
		int K = Integer.parseInt(reader.readLine()); // 시작 정점

		// 리스트 초기화
		List<List<Node>> list = new ArrayList<>(V + 1);
		for (int i = 0; i < V + 1; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int u = Integer.parseInt(tokenizer.nextToken()); // 시작
			int v = Integer.parseInt(tokenizer.nextToken()); // 끝
			int w = Integer.parseInt(tokenizer.nextToken()); // 가중치

			list.get(u).add(new Node(v, w));
		}

		boolean[] visited = new boolean[V + 1]; // 탐색 여부 저장
		int[] distance = new int[V + 1]; // 각 정점 별 최소 이동거리 저장
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[K] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(K, distance[K]));

		while (!pq.isEmpty()) {
			Node current = pq.poll();

			if (visited[current.vertex]) continue;

			visited[current.vertex] = true;

			for (Node node : list.get(current.vertex)) {
				if (!visited[node.vertex] && distance[node.vertex] > distance[current.vertex] + node.distance) {
					distance[node.vertex] = distance[current.vertex] + node.distance;
					pq.offer(new Node(node.vertex, distance[node.vertex]));
				}
			}
		}

		for (int i = 1; i < V + 1; i++) {
			if (distance[i] == Integer.MAX_VALUE) sb.append("INF");
			else sb.append(distance[i]);

			sb.append("\n");
		}

		System.out.println(sb);
	}
	
}
