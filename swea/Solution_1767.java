import java.util.*;
import java.io.*;

public class Solution_1767 {
    static BufferedReader br; static BufferedWriter bw; static StringTokenizer st;

    static int n, maxCoreCnt, minLen;
    static int[][] map; static List<int[]> cores;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        //br = new BufferedReader(new FileReader("./input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine().trim());
        for(int tc=1; tc<=t; tc++) {
            init();
            run();
            outprin(tc);
        }
        br.close();
        bw.close();
    }

    static void init() throws IOException {
        n = Integer.parseInt(br.readLine().trim());
        maxCoreCnt = 0; minLen = Integer.MAX_VALUE;
        map = new int[n][n];
        cores = new ArrayList<>();

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1 && i>0 && j>0 && i<n-1 && j<n-1)
                    cores.add(new int[]{i, j});
            }
        }        
    }

    static void run() {
        dfs(0, 0, 0);
    }

    static void outprin(int tc) throws IOException {
        bw.write("#" + tc + " " + minLen);
        bw.newLine();
        bw.flush();
    }

    static void dfs(int curCoreIdx, int connCoreCnt, int lenSum) {
        if(curCoreIdx == cores.size()) {
            if(connCoreCnt > maxCoreCnt) {
                maxCoreCnt = connCoreCnt;
                minLen = lenSum;
            } else if(connCoreCnt == maxCoreCnt) {
                minLen = Math.min(minLen, lenSum);
            }
            return;
        }

        // pruning
        if(cores.size() - curCoreIdx + connCoreCnt < maxCoreCnt)
            return;
        
        int[] core = cores.get(curCoreIdx);
        int r = core[0], c = core[1];

        for(int d=0; d<4; d++) {
            if(canConnect(r, c, d)) {
                int len = connect(r, c, d, 2);
                dfs(curCoreIdx+1, connCoreCnt+1, lenSum+len);
                connect(r, c, d, 0);
            }
            else {
                dfs(curCoreIdx+1, connCoreCnt, lenSum);
            }
        }
    }

    static boolean canConnect(int r, int c, int d) {
        int nr = r + dx[d], nc = c + dy[d];

        while(0<=nr && 0<=nc && nr<n && nc<n) {
            if(map[nr][nc] != 0)
                return false;
            nr += dx[d]; 
            nc += dy[d];
        }
        return true;
    }

    static int connect(int r, int c, int d, int val) {
        int len = 0;
        int nr = r + dx[d], nc = c + dy[d];

        while(0<=nr && 0<=nc && nr<n && nc<n) {
            map[nr][nc] = val;
            len++;
            nr += dx[d];
            nc += dy[d];
        }

        return len;
    }
}