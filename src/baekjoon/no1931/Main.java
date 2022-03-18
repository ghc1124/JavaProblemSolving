package baekjoon.no1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        TreeSet<Meeting> treeSet = new TreeSet<>();
        int count = 1;
        while (N-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            treeSet.add(new Meeting(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken())));
        }

        Iterator<Meeting> iterator = treeSet.iterator();
        Meeting temp = iterator.next(); // 초깃값
        while (iterator.hasNext()) {
            Meeting current = iterator.next();
            if (current.start >= temp.end) {
                count++;
                temp = current;
            }
        }

        System.out.println(count);

        reader.close();
    }

}

class Meeting implements Comparable<Meeting> {

    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting o) {
        if (this.end == o.end) {
            if (this.start == o.start) {
                return -1;
            } else {
                return this.start - o.start;
            }
        } else {
            return this.end - o.end;
        }
    }

}