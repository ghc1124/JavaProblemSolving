import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 0;

        char[][] arr = new char[8][8];
        for (int i = 0; i < 8; i++) {
            arr[i] = reader.readLine().toCharArray();

            if (i % 2 == 0) {
                // 짝수인 경우
                for (int j = 0; j < 8; j += 2) {
                    if (arr[i][j] == 'F') cnt++;
                }
            } else {
                for (int j = 1; j < 8; j += 2) {
                    if (arr[i][j] == 'F') cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

}