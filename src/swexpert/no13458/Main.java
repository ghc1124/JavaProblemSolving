package swexpert.no13458;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine()); // 시험장의 개수
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine()); // 각 시험장의 응시자 수
        int[] examinee = new int[N];
        for (int i = 0; i < N; i++) {
            examinee[i] = Integer.parseInt(tokenizer.nextToken());
        }

        tokenizer = new StringTokenizer(reader.readLine()); // B, C
        int B = Integer.parseInt(tokenizer.nextToken()); // B
        int C = Integer.parseInt(tokenizer.nextToken()); // C

        long result = N;

        for (int i = 0; i < N; i++) {
            examinee[i] -= B;

            if (examinee[i] > 0) result += (int) Math.ceil(1.0 * examinee[i] / C);
        }

        System.out.println(result);
    }

}
