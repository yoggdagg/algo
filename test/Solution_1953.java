import java.util.*;
import java.io.*;

public class Solution_1953 {
    static BufferedReader br; static BufferedWriter bw; static StringTokenizer st;

    static int n, m, sr, sc, L, result;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] arggs) throws IOException {
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        br = new BufferedReader(new FileReader("./input.txt"));
        int t = Integer.parseInt(br.readLine().trim());

        for(int tc=1; tc<=t; tc++) {
            init();
            run();
            outprint();
        }
        br.close();
        bw.close();
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sr = Integer.parseInt(st.nextToken());
        sc = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        result = 0;
        map = new int[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void run() throws IOException {
        visited = new boolean[n][m];
        visited[sr][sc] = true;
        dfs(sr, sc, 1, 1);
    }

    static void outprint() throws IOException {
        for(int[] arr : map)
        bw.write(Arrays.toString(arr) + "\n");
        
        bw.flush();
    }

    static void dfs(int curR, int curC, int t, int cnt) {
        if(t == L) {
            result = cnt;
        }

        for(int d=0; d<4; d++) {
            int nx = curR + dx[d];
            int ny = curC + dy[d];

            if(nx<0 || ny<0 || n<=nx || m<=ny || visited[nx][ny])
                continue;
            if(canConnect(curR, curC, nx, ny, d)) {
                dfs(nx, ny, t+1, cnt+1);
            }
        }
    }

    static boolean canConnect(int curR, int curC, int nx, int ny, int d) {
        
    }
}