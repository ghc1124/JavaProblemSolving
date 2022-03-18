package jungol.no1828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    static class Chemical implements Comparable<Chemical> {

        private int low;
        private int high;

        public Chemical(int low, int high) {
            this.low = low;
            this.high = high;
        }

        @Override
        public int compareTo(Chemical o) {
            return this.high != o.high ? this.high - o.high : this.low - o.low;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        TreeSet<Chemical> treeSet = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            treeSet.add(new Chemical(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken())));
        }

        int refrigerator = 0;
        int count = 1;

        Iterator<Chemical> iterator = treeSet.iterator();
        if (iterator.hasNext())  refrigerator = iterator.next().high;
        while (iterator.hasNext()) {
            Chemical temp = iterator.next();
            if (temp.low > refrigerator) {
                count++;
                refrigerator = temp.high;
            }
        }

        System.out.println(count);
    }

}
