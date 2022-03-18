package baekjoon.no1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken()); // N개의 포켓몬
        int M = Integer.parseInt(tokenizer.nextToken()); // M개의 문제

        StringBuilder sb = new StringBuilder();

        HashMap<Integer, String> indexMap = new HashMap<>();
        HashMap<String, Integer> stringMap = new HashMap<>();

        int index = 1;

        while (N-- > 0) {
            String temp = reader.readLine();
            indexMap.put(index, temp);
            stringMap.put(temp, index++);
        }

        for (int i = 0; i < M; i++) {
            String temp = reader.readLine();
            if (stringMap.containsKey(temp)) sb.append(stringMap.get(temp));
            else sb.append(indexMap.get(Integer.parseInt(temp)));
            sb.append("\n");
        }

        System.out.println(sb);
    }

}
