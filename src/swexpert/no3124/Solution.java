package swexpert.no3124;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	private static class Edge implements Comparable<Edge> {
		
		int from; 	// 시작
		int to;		// 끝
		int weight;	// 가중치
		
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		// 가중치 기준 오름차순 정렬
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
		
	}
	
	private static int[] parents;
	
	private static void makeSet(int N) {
		parents = new int[N + 1];
		
		for (int i = 1; i < N + 1; i++) parents[i] = i;
	}
	
	private static int findSet(int n) {
		if (n == parents[n]) return n; // 본인이 곧 대표자인 경우
		
		return parents[n] = findSet(parents[n]); // 대표자까지 타고 타고
	}
	
	private static boolean unionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if (aRoot == bRoot) return false; // 이미 같은 트리
		
		parents[bRoot] = aRoot; // b의 대표자를 a의 대표자로 설정
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine()); // 테케 수
		
		for (int i = 0; i < T; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int V = Integer.parseInt(tokenizer.nextToken()); // 정점의 개수
			int E = Integer.parseInt(tokenizer.nextToken()); // 간선의 개수
			
			Edge[] edgeList = new Edge[E]; // 간선 리스트
			for (int j = 0; j < E; j++) {
				tokenizer = new StringTokenizer(reader.readLine());
				int from = Integer.parseInt(tokenizer.nextToken());
				int to = Integer.parseInt(tokenizer.nextToken());
				int weight = Integer.parseInt(tokenizer.nextToken());
				edgeList[j] = new Edge(from, to, weight);
			}
			
			Arrays.sort(edgeList); // 간선 리스트를 가중치를 기준으로 오름차순 정렬
			
			makeSet(V); // 초기 배열 설정
			
			int result = 0;
			int cnt = 0;
			
			for (Edge edge : edgeList) {
				if (unionSet(edge.from, edge.to)) { // 시작 정점과 끝 정점을 정상적으로 합친 경우
					result += edge.weight;
					if (++cnt == V - 1) break;
				}
			}
			
			sb.append("#").append(i + 1).append(" ");
			sb.append(result).append("\n");
		}
		
		System.out.println(sb);
	}

}
