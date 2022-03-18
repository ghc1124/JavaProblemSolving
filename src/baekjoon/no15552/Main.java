package baekjoon.no15552;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(reader.readLine());

        while (T-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            sb.append(Integer.parseInt(tokenizer.nextToken()) + Integer.parseInt(tokenizer.nextToken())).append("\n");
        }
        writer.write(sb.toString());
        writer.flush();
        writer.close();
    }

}
