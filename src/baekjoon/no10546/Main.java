package baekjoon.no10546;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        StringBuilder sb = new StringBuilder();

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String temp = reader.readLine();

            if (hashMap.containsKey(temp)) hashMap.put(temp, hashMap.get(temp) + 1);
            else hashMap.put(temp, 1);
        }

        for (int i = 0; i < N - 1; i++) {
            String temp = reader.readLine();
            hashMap.put(temp, hashMap.get(temp) - 1);
        }

        for (String str : hashMap.keySet()) {
            if (hashMap.get(str) > 0) sb.append(str).append("\n");
        }

        System.out.println(sb);
    }

}
