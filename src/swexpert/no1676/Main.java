package swexpert.no1676;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        BigInteger factorial = new BigInteger("1");

        for (int i = N; i > 0; i--) {
            factorial = factorial.multiply(new BigInteger(i + ""));
        }

        System.out.println(factorial);

        int result = 0;

        char[] temp = factorial.toString().toCharArray();
        for (int i = temp.length - 1; i >= 0; i--) {
            if (temp[i] == '0') result++;
            else break;
        }

        System.out.println(result);
    }

}
