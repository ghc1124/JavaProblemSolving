import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        StringTokenizer tokenizer = null;

        for (int t = 0; t < T; t++) {
            tokenizer = new StringTokenizer(reader.readLine(), ",");
            sb.append(Integer.parseInt(tokenizer.nextToken()) + Integer.parseInt(tokenizer.nextToken()));
            sb.append("\n");
        }

        System.out.println(sb);
    }

}
