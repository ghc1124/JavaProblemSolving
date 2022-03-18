package baekjoon.no2258;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static class Meat implements Comparable<Meat> {

        int weight;
        int price;

        public Meat(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Meat o) {
            if (this.price == o.price) {
                return o.weight - this.weight;
            } else {
                return this.price - o.price;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken()); // 고기 덩어리 수
        int M = Integer.parseInt(tokenizer.nextToken()); // 필요한 고기의 양

        List<Meat> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            list.add(new Meat(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken())));
        }

        Collections.sort(list);

        int totalWeight = list.get(0).weight;
        int totalPrice = list.get(0).price;

        int result = Integer.MAX_VALUE;

        boolean flag = false;

        for (int i = 1, size = list.size(); i < size; i++) {
            if (list.get(i).price == list.get(i - 1).price) { // 가격이 같은 경우
                totalPrice += list.get(i).price;
            } else { // 가격이 다른 경우
                totalPrice = list.get(i).price;
            }

            totalWeight += list.get(i).weight;

            if (totalWeight >= M) {
                flag = true;
                result = Math.min(result, totalPrice);
            }
        }

        System.out.println(flag ? result : -1);
    }

}
