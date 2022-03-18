package baekjoon.no1193;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();
        int temp = 1;
        int x = 1; // 분자
        int y = 1; // 분모
        int count = 1;

        while (temp < X) {
            temp += ++count;
        }

        int start = temp - count + 1; // 해당 층의 시작 번호
        int result = X - start + 1;
        if (count % 2 == 0) { // 짝수층의 경우
            for (int i = 1; i <= count; i++) {
                x = i;
                y = (count + 1 - i);
                if (i == result) {
                    break;
                }
            }
        } else { // 홀수층의 경우
            for (int i = 1; i <= count; i++) {
                x = (count + 1 - i);
                y = i;
                if (i == result) {
                    break;
                }
            }
        }

        System.out.println(x + "/" + y);
    }

}
