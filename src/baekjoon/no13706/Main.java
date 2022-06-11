package baekjoon.no13706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BigInteger N = new BigInteger(reader.readLine());

        BigInteger start = new BigInteger("0");
        BigInteger end = N;

        while (!start.equals(end)) {
            BigInteger mid = start.add(end).divide(new BigInteger("2"));

            BigInteger target = mid.multiply(mid);

            if (target.compareTo(N) == -1) start = mid.add(new BigInteger("1"));
            else end = mid;
        }

        System.out.println(start);
    }

}
