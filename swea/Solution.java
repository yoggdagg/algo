import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static int n, k, result;
    static int max;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        br = new BufferedReader(new FileReader("./input.txt"));

        int t = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= t; tc++) {
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
        k = Integer.parseInt(st.nextToken());
        max = 0;

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }
    }

    static void run() throws IOException {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == max) {
                    visited = new boolean[n][n];
                    dfs(i, j, 1, false);
                }
            }
        }
    }

    static void outprint(int tc) throws IOException {
        bw.write("#" + tc + " " + result + "\n");
        bw.flush();
    }

    static void dfs(int x, int y, int cnt, boolean used) {
        visited[x][y] = true;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || n <= nx || ny < 0 || n <= ny || visited[nx][ny])
                continue;

            int nextValue = map[nx][ny];
            if (nextValue >= map[x][y]) {
                if (nextValue - k < map[x][y]) {
                    visited[nx][ny] = true;
                    map[nx][ny] = map[x][y] - 1;
                    dfs(nx, ny, cnt + 1, true);
                    visited[nx][ny] = false;
                    map[nx][ny] = nextValue;
                }
            } else {
                visited[nx][ny] = true;
                dfs(nx, ny, cnt + 1, true);
                visited[nx][ny] = false;
            }

        }
        result = Math.max(result, cnt);
    }
}