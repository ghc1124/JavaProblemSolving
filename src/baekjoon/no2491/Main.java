package baekjoon.no2491;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] arr = new int[N];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int result = 1;
        int ascCount = 1;
        int descCount = 1;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int temp = arr[0];

        for (int i = 1; i < N; i++) {
            if (arr[i] > temp) {
                ascCount++;
                result = Math.max(descCount, result);
                descCount = 1;
            } else if (arr[i] < temp) {
                descCount++;
                result = Math.max(ascCount, result);
                ascCount = 1;
            } else {
                ascCount++;
                descCount++;
            }

            temp = arr[i];
        }

        result = Math.max(Math.max(ascCount, descCount), result);
        System.out.println(result);
    }

}
