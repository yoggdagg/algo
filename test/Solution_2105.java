import java.util.*;
import java.io.*;

public class Solution_2105 {
    static BufferedReader br; static BufferedWriter bw; static StringTokenizer st;

    static int n, max;
    static int[][] map;

    static int[] dr = {-1, -1, 1, 1};
    static int[] dc = {-1, 1, 1, -1};

    public static void main(String[] args) throws IOException {
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
        max = -1;
        map = new int[n][n];

        for(int i=0; i<n; i++) {
            String line = br.readLine().trim();
            for(int j=0; j<n; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
    }

    static void run() throws IOException {
        // Implementation of the main logic goes here
    }

    static void outprint(int tc) throws IOException {
        bw.write("#" + tc + " " + max + "\n");
        bw.flush();
    }

    
}