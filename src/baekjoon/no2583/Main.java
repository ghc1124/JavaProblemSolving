package baekjoon.no2583;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int N,M,K,count;
    static int[][] map;
    static boolean[][] select;
    static int[] dy = {-1, 1, 0 ,0};
    static int[] dx = {0, 0, -1, 1};

    static ArrayList<Integer> al = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        K = Integer.parseInt(str[2]);

        map = new int[N][M];
        select = new boolean[N][M];

        for (int k = 0; k < K; k++) {
            String[] str2 = br.readLine().split(" ");

            int x = Integer.parseInt(str2[0]);
            int y = Integer.parseInt(str2[1]);
            int x2 = Integer.parseInt(str2[2]);
            int y2 = Integer.parseInt(str2[3]);

            for (int i = y; i < y2; i++) {
                for (int j = x; j < x2; j++) {
                    map[i][j] = 1;
                }
            }
        }
        for (int i = 0; i <N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        for (int i = 0; i <N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]!= 0 || select[i][j]) {
                    continue;
                }
                count = 0;
                System.out.println(i+" "+j);
                dfs(i,j);
                al.add(count);
            }
        }

        System.out.println(al.size());
        for (int n : al) {
            System.out.println(n);
        }


    }
    static void dfs(int y, int x) {
        count++;

        select[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny<0||nx<0||ny>=N||nx>=N) continue;
            if(map[ny][nx] != 0 || select[ny][nx]) continue;


            dfs(ny,nx);

        }
    }
}