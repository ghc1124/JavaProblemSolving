package baekjoon.no3040;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] people = new int[9];
        boolean[] isSelected = new boolean[9];
        for (int i = 0; i < people.length; i++) {
            people[i] = Integer.parseInt(reader.readLine());
        }

        combination(people, isSelected, 0, 0, 0);

        System.out.println(sb);
    }

    private static void combination(int[] target, boolean[] flag, int start, int count, int sum) {
        if (sum > 100) return;
        if (count == 7) {
            if (sum == 100) {
                for (int i = 0; i < flag.length; i++) {
                    if (flag[i]) {
                        sb.append(target[i]).append("\n");
                    }
                }
            }
        }

        for (int i = start; i < target.length; i++) {
            flag[i] = true;
            combination(target, flag, i + 1, count + 1, sum + target[i]);
            flag[i] = false;
        }
    }

}
