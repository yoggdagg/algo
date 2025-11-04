import java.util.*;
import java.io.*;

public class Solution_2117 {
    static BufferedReader br; static BufferedWriter bw; static StringTokenizer st;

    static int n, m, maxCnt;
    static int[][] map;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //br = new BufferedReader(new FileReader("./input.txt"));

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
        st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maxCnt = 0;
        
        map = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void run() throws IOException {
        for(int k=1; k<=n+1; k++) {
            for(int r=0; r<n; r++) {
                for(int c=0; c<n; c++) {
                    int houseCnt = 0;

                    for(int i=0; i<n; i++) {
                        for(int j=0; j<n; j++) {
                            int dist = Math.abs(i-r) + Math.abs(j-c);
                            if(dist < k && map[i][j] == 1) 
                                houseCnt++;
                        }
                    }
                    if(getCost(k) <= houseCnt * m)
                        maxCnt = Math.max(maxCnt, houseCnt);
                }
            }
        }
    
    }

    static void outprint(int tc) throws IOException {
        bw.write("#" + tc + " " + maxCnt + "\n");
        bw.flush();
    }

    static int getCost(int k) {
        return (k*k) + ((k-1)*(k-1));
    }
}