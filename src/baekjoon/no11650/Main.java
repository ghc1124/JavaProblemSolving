package baekjoon.no11650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        TreeSet<Nums> treeSet = new TreeSet<>();
        while (N-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int num1 = Integer.parseInt(tokenizer.nextToken());
            int num2 = Integer.parseInt(tokenizer.nextToken());
            treeSet.add(new Nums(num1, num2));
        }

        for (Nums nums : treeSet) {
            sb.append(nums).append("\n");
        }

        System.out.println(sb);
    }

}

class Nums implements Comparable<Nums> {

    int num1;
    int num2;

    public Nums(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public int compareTo(Nums o) {
        if (this.num1 == o.num1) {
            if (this.num2 == o.num2) {
                return -1;
            } else {
                return this.num2 - o.num2;
            }
        } else {
            return this.num1 - o.num1;
        }
    }

    @Override
    public String toString() {
        return num1 + " " + num2;
    }

}