package swexpert.no5643;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Test {

    static int T, N, M, count;;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    static int[] student;
    static boolean[] visit;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());



        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());

            student = new int[N+1];

            for (int i = 0; i <= N; i++) {
                list.add(new ArrayList<Integer>());
            }

            StringTokenizer st = null;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                list.get(from).add(to);
            }

            for (int i = 1; i <= N; i++) {
                visit = new boolean[N+1];
                student[i] += list.get(i).size();
                dfs(i);
            }

            count = 0;
            for (int i = 1; i <= N; i++) {
                if(student[i]==N-1) {
                    count++;
                }
            }

            System.out.println(Arrays.toString(student));

            System.out.println("#"+t+" "+count);
        }

    }
    static void dfs(int idx) {
        visit[idx] = true;

        for (int i : list.get(idx)) {
            if(visit[i]) continue;
            student[i]++;
            dfs(i);
        }
    }
}