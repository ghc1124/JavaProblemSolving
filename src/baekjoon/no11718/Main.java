package baekjoon.no11718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String target = "";

        while ((target = reader.readLine()) != null) {
            sb.append(target).append("\n");
        }


        System.out.println(sb);
    }

}
