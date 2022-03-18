package baekjoon.no2941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String target = reader.readLine();
        String pattern = "c=|c-|dz=|d-|lj|nj|s=|z=";

        System.out.println(target.replaceAll(pattern, "#").length());
    }

}
