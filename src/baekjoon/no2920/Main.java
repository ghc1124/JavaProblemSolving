package baekjoon.no2920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int[] scale = new int[8];
        for (int i = 0; i < 8; i++) {
            scale[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int asCnt = 0, desCnt = 0, mixCnt = 0;

        for (int i = 0; i < 4; i++) {
            int temp = scale[i] - scale[i + 4];
            if (temp == 4) desCnt++;
            else if (temp == -4) asCnt++;
            else mixCnt++;
        }

        System.out.println(asCnt == 4 ? "ascending" : desCnt == 4 ? "descending" : "mixed");
    }

}
