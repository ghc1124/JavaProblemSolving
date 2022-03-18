package baekjoon.no2477;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(reader.readLine());
        int[] direct = new int[6];
        int[] length = new int[6];

        for (int i = 0; i < 6; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            direct[i] = Integer.parseInt(tokenizer.nextToken());
            length[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int x = 0, y = 0;

        for (int i = 0; i < 6; i++) {
            if (direct[i] == direct[(i + 2) % 6]) {
                if (direct[(i + 1) % 6] == direct[(i + 3) % 6]) {
                    x = length[(i + 1) % 6];
                    y = length[(i + 2) % 6];
                    break;
                }
            }
        }

        int hori = 0;
        int vert = 0;

        for (int i = 0; i < 6; i++) {
            if (direct[i] == 1 || direct[i] == 2) hori += length[i];
            else vert += length[i];
        }

        System.out.println(((hori / 2) * (vert / 2) - x * y) * K);
    }

}
