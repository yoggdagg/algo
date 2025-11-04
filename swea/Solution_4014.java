import java.util.*;
import java.io.*;

public class Solution_4014 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static int n, x, result;
    static int[][] map;

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
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        result = 0;

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void run() {
        for (int i = 0; i < n; i++) {
            if (check(map[i]))
                result++;

            int[] col = new int[n];
            for (int j = 0; j < n; j++) {
                col[j] = map[j][i];
            }
            if (check(col))
                result++;
        }
    }

    static void outprint(int tc) throws IOException {
        bw.write("#" + tc + " " + result + "\n");
        bw.flush();
    }

    static boolean check(int[] arr) {
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1])
                continue;
            if (Math.abs(arr[i] - arr[i + 1]) > 1)
                return false;

            // 오르막길 체크
            if (arr[i] + 1 == arr[i + 1]) {
                for (int j = i - x + 1; j <= i; j++) {
                    if (j < 0 || arr[j] != arr[i] || visited[j])
                        return false;
                    visited[j] = true;
                }
            }
            // 내리막길 체크
            else if (arr[i] == arr[i + 1] + 1) {
                for (int j = i + 1; j <= i + x; j++) {
                    if (j >= n || arr[j] != arr[i + 1] || visited[j])
                        return false;
                    visited[j] = true;
                }
            }
        }
        return true;
    }

}
