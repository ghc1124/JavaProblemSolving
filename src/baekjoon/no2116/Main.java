package baekjoon.no2116;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine()); // 주사위 개수
		
		List<List<Integer>> dice = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			dice.add(new ArrayList<>(6));
			for (int j = 0; j < 6; j++) {
				dice.get(i).add(Integer.parseInt(tokenizer.nextToken()));
			}
		}
		
		// 서로 마주보고 있는 숫자 인덱스 목록
		HashMap<Integer, Integer> pair = new HashMap<>();
		pair.put(0, 5);
		pair.put(5, 0);
		pair.put(1, 3);
		pair.put(3, 1);
		pair.put(2, 4);
		pair.put(4, 2);
		
		int answer = 0;
		
		// 각 경우의 수 처리
		for (Map.Entry<Integer, Integer> entry : pair.entrySet()) {
			// 초깃값 세팅
			int bottom = entry.getKey();	// 밑 인덱스
			int top = entry.getValue();		// 위 인덱스
			
			int topValue = dice.get(0).get(top); // 위의 값 -> 이게 추후 밑 값으로 가야됨
			
			int result = 0;
			
			for (List<Integer> list : dice) {
				bottom = list.indexOf(topValue); 	// 새로운 밑 찾기
				top = pair.get(bottom);				// 위의 값에 해당하는 인덱스
				
				int tempMax = 0;
				
				for (int i = 0; i < list.size(); i++) {
					if (i == bottom || i == top) continue; 
					tempMax = Math.max(tempMax, list.get(i));
				}
				
				result += tempMax;
				
				topValue = list.get(top);
			}
			
			answer = Math.max(answer, result);
		}
		
		System.out.println(answer);
	}

}
