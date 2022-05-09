package baekjoon.no15666;

import java.util.HashSet;
import java.util.Set;

public class Test {

    public static void main(String[] args) {
        Set<Integer> test = new HashSet<>();
        test.add(5);
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(0);

        for (int i : test) {
            System.out.println(i);
        }
    }

}
