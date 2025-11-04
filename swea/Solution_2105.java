import java.util.*;
import java.io.*;

public class Solution_2105 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static int n, sr, sc, result;
    static int[][] map;
    static boolean[] visited;

    // 좌상 우상 우하 좌하
    static int[] dx = { -1, -1, 1, 1 };
    static int[] dy = { -1, 1, 1, -1 };

    public static void main(String[] args) throws IOException {
        // br = new BufferedReader(new InputStreamReader(System.in));
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
        n = Integer.parseInt(br.readLine().trim());
        result = -1;
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void run() throws IOException {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited = new boolean[101];
                visited[map[i][j]] = true;
                sr = i;
                sc = j;
                dfs(i, j, 0, 1);
            }
        }
    }

    static void outprint(int tc) throws IOException {

        bw.write("#" + tc + " " + result);
        bw.newLine();
        bw.flush();
    }

    static void dfs(int r, int c, int turn, int cnt) {
        int nr = r + dx[turn];
        int nc = c + dy[turn];

        if (nr == sr && nc == sc && turn == 3) {
            result = Math.max(result, cnt);
            return;
        }

        if (0 <= nr && nr < n && 0 <= nc && nc < n) {
            if (!visited[map[nr][nc]]) {
                visited[map[nr][nc]] = true;
                dfs(nr, nc, turn, cnt + 1);

                if (turn < 3)
                    dfs(nr, nc, turn + 1, cnt + 1);
                visited[map[nr][nc]] = false;
            }
        }
    }
}