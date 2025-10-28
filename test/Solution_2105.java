import java.util.*;
import java.io.*;

public class Solution_2105 {
    static BufferedReader br; static BufferedWriter bw; static StringTokenizer st;

    static int n, result;
    static int[][] map;
    static boolean[] visited;

    // 좌상 -> 우상 -> 우하 -> 좌하
    static int[] dx = {-1, -1, 1, 1};
    static int[] dy = {-1, 1, 1, -1};
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        br = new BufferedReader(new FileReader("./input.txt"));

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
        map = new int[n][n];
        result = -1;
        visited = new boolean[101];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void run() throws IOException{
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                // i,j에서 출발
                visited = new boolean[101];
                searching(i, j, i, j, 0, 0);
            }
        }
    }

    static void outprint(int tc) throws IOException {
        bw.write("#" + tc + " " + result + "\n");
        bw.flush();
    }

    static void searching(int sr, int sc, int curR, int curC, int dir, int cnt) {
        for(int d=dir; d<4; d++) {
            int nr = curR + dx[d];
            int nc = curC + dy[d];

            if(nr<0 || nr>=n || nc<0 || nc>=n) continue;
            if(visited[map[nr][nc]]) continue;
        }


    }
}
