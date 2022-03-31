package swexpert.no3124;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	private static int[] parents;

	private static void makeSet(int n) {
		parents = new int[n + 1]; // 1-based index

		for (int i = 0; i <= n; i++) {
			parents[i] = i;
		}
	}

	private static boolean unionSet(int a, int b) {
		int parentA = findSet(a);
		int parentB = findSet(b);

		if (parentA == parentB) return false;

		parents[parentB] = parentA;

		return true;
	}

	private static int findSet(int a) {
		if (a == parents[a]) return a;

		return parents[a] = findSet(parents[a]); // Path Compression
	}

	private static class Edge implements Comparable<Edge> {

		int from;
		int to;
		int weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}

	}

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(reader.readLine()); // 테스트케이스 개수

		for (int t = 0; t < T; t++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int V = Integer.parseInt(tokenizer.nextToken()); // 정점 개수
			int E = Integer.parseInt(tokenizer.nextToken()); // 간선 개수

			PriorityQueue<Edge> pq = new PriorityQueue<>();
			makeSet(V);

			for (int i = 0; i < E; i++) {
				tokenizer = new StringTokenizer(reader.readLine());
				int from = Integer.parseInt(tokenizer.nextToken());
				int to = Integer.parseInt(tokenizer.nextToken());
				int weight = Integer.parseInt(tokenizer.nextToken());

				pq.offer(new Edge(from, to, weight));
			}

			int cnt = 0;
			int ans = 0;

			while (!pq.isEmpty()) {
				Edge curr = pq.poll();
				int from = curr.from;
				int to = curr.to;
				int weight = curr.weight;

				if (unionSet(from, to)) {
					ans += weight;
					if (++cnt == V - 1) break;
				}
			}

			sb.append("#").append(t + 1).append(" ");
			sb.append(ans).append("\n");
		}

		System.out.println(sb);
	}

}
