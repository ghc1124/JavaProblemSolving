package baekjoon.no2635;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        int N = scanner.nextInt();
        list.add(N);
        int max = 0;

        for (int i = N; i > 0; i--) {
            list.add(i);
            int index = 2;
            while (true) {
                int temp = list.get(index - 2) - list.get(index++ - 1);
                if (temp < 0) break;
                list.add(temp);
            }
            if (list.size() > max) {
                max = list.size();
                result = new ArrayList<>(list);
            }
            list.clear();
            list.add(N);
        }

        sb.append(max).append("\n");
        for (int n : result) {
            sb.append(n + " ");
        }
        System.out.println(sb);
    }

}
