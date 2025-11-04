import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader br; static BufferedWriter bw; static StringTokenizer st;

    static int[] trees;
    static int n, max, result;

    public static void main(String[] args) throws IOException {
        //br = new BufferedReader(new FileReader("./input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine().trim());

        for(int tc=1; tc<=t; tc++) {
            init();
            run();
            outprint(tc);
        }
        br.close();
        bw.close();
    }

        static void init() throws IOException {
            n = Integer.parseInt(br.readLine().trim());
            max = 0;
            trees = new int[n];

            st = new StringTokenizer(br.readLine().trim());
            for(int i=0; i<n; i++) {
                trees[i] = Integer.parseInt(st.nextToken());
                max = Math.max(max, trees[i]);
            }
        }

        static void run() {
            int odd = 0, even = 0;
            result = 0;

            for(int i=0; i<n; i++) {
                int diff = max - trees[i];
                even += diff / 2;
                odd += diff % 2;
            }

            while( even > odd + 1) {
                even--;
                odd += 2;
            }

            
            if(odd > even) {
                result = odd * 2 - 1;
            } else {
                result = even * 2;
            }

        }

        static void outprint(int tc) throws IOException {
            bw.write("#" + tc + " " + result + "\n");
            bw.flush();
        }
    
}