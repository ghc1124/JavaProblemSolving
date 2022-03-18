package baekjoon.no18870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            hashMap.put(i, Integer.parseInt(tokenizer.nextToken()));
        }
        ArrayList<Map.Entry<Integer, Integer>> arrayList = new ArrayList<>(hashMap.entrySet());
        arrayList.sort(Map.Entry.comparingByValue(Collections.reverseOrder()));

        int beforeKey = arrayList.get(0).getKey();
        int beforeValue = Integer.MIN_VALUE;

        for (int i = 0; i < arrayList.size(); i++) {
            int targetKey = arrayList.get(i).getKey();
            int targetValue = arrayList.get(i).getValue();
            int save = targetValue;
            int count = 0;

            if (targetValue != beforeValue) {
                for (int j = i + 1; j < arrayList.size(); j++) {
                    int temp = arrayList.get(j).getValue();
                    if (temp < targetValue) {
                        count++;
                        targetValue = temp;
                    }
                }
            } else {
                count = hashMap.get(beforeKey);
            }
            beforeKey = targetKey;
            beforeValue = save;

            hashMap.put(targetKey, count);
        }

        hashMap.forEach((K, V) -> sb.append(V).append(" "));

        System.out.println(sb);
    }

}
