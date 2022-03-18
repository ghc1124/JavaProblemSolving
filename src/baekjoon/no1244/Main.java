package baekjoon.no1244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int switchCount = Integer.parseInt(reader.readLine());
        int[] switches = new int[switchCount + 1];
        StringTokenizer token = new StringTokenizer(reader.readLine());
        for (int i = 1; i <= switchCount; i++) {
            switches[i] = Integer.parseInt(token.nextToken());
        }
        int studentCount = Integer.parseInt(reader.readLine());
        int[][] studentList = new int[studentCount][2];
        for (int i = 0; i < studentCount; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            studentList[i][0] = Integer.parseInt(tokenizer.nextToken());
            studentList[i][1] = Integer.parseInt(tokenizer.nextToken());
        }
        // 배열 인덱스 1부터 센다. 마지막은 switchCount 이다.
        for (int i = 0; i < studentCount; i++) {
            int card = studentList[i][1];
            if (studentList[i][0] == 1) { // 남자일 경우
                while (card <= switchCount) {
                    switches[card] = (switches[card] + 1) % 2;
                    card += studentList[i][1];
                }
            } else { // 여자일 경우
                if (card > 1 && card < switchCount) {
                    int left = card - 1;
                    int right = card + 1;

                    while (left > 0 && right <= switchCount) {
                        if (switches[left] == switches[right]) {
                            if (left == 1 || right == switchCount) {
                                break;
                            } else {
                                left--;
                                right++;
                            }
                        } else { // 서로 다른 경우
                            left++;
                            right--;
                            break;
                        }
                    }

                    for (int j = left; j <= right; j++) {
                        switches[j] = (switches[j] + 1) % 2;
                    }

                } else {
                    // card만 수정
                    switches[card] = (switches[card] + 1) % 2;
                }
            }
        }

        for (int i = 1; i <= switchCount; i++) {
            System.out.print(switches[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
    }

}
