package swexpert.no1233;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int problemNum = 1;
        BinaryTree binaryTree;
        for (int i = 0; i < 10; i++) {
            int N = Integer.parseInt(reader.readLine());
            binaryTree = new BinaryTree(N);
            int answer = 1;
            while (N-- > 0) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                tokenizer.nextToken(); // 정점 숫자
                binaryTree.add(tokenizer.nextToken().charAt(0)); // 트리에 삽입
            }
            char[] temp = binaryTree.inOrder().toCharArray(); // 중위 선회
            for (int j = 1; j < temp.length; j += 2) {
                if (temp[j] >= '0') {
                    answer = 0;
                    break;
                }
            }
            sb.append("#");
            sb.append(problemNum++).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

}

class BinaryTree {

    private char[] binaryTree;
    private final int size;
    private int lastIndex;
    private StringBuilder sb = new StringBuilder();

    public BinaryTree(int size) {
        this.size = size;
        binaryTree = new char[size + 1];
    }

    public boolean isEmpty() {
        return lastIndex == 0;
    }

    public boolean isFull() {
        return lastIndex == size;
    }

    public void add(char c) {
        if (isFull()) return;

        binaryTree[++lastIndex] = c;
    }

    public String inOrder() {
        if (isEmpty()) return null;
        inOrder(1);
        return sb.toString();
    }

    private void inOrder(int index) {
        if (index > lastIndex) return;

        inOrder(index * 2);
        sb.append(binaryTree[index]);
        inOrder(index * 2 + 1);
    }

}
