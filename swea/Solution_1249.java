import java.util.*;
import java.io.*;

public class Solution_1249 {
    static BufferedReader br; static BufferedWriter bw;
    static int n;
    static int[][] map, dist;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        br = new BufferedReader(new FileReader("./input.txt"));

        int t = Integer.parseInt(br.readLine().trim());
        for(int tc=1; tc<=t; tc++) {
            init();
            dijkstra();
            outprint(tc);
        }
        br.close();
        bw.close();
    }

    static void init() throws IOException {
        n = Integer.parseInt(br.readLine().trim());
        map = new int[n][n];
        dist = new int[n][n];

        for(int i=0; i<n; i++) {
            String line = br.readLine().trim();
            for(int j=0; j<n; j++) {
                map[i][j] = line.charAt(j) - '0';
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    static void dijkstra() {
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.cost));
        dist[0][0] = 0;
        pq.offer(new Point(0, 0, 0));

        while(!pq.isEmpty()) {
            Point curr = pq.poll();

            if(curr.r == n-1 && curr.c == n-1) {
                return;
            } 

            for(int d=0; d<4; d++) {
                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];

                if(nr<0 || nr>=n || nc<0 || nc>=n) continue;
                int nextCost = curr.cost + map[nr][nc];
                if(nextCost < dist[nr][nc]) {
                    dist[nr][nc] = nextCost;
                    pq.offer(new Point(nr, nc, nextCost));
                }
            }
        }
    }

    static void outprint(int tc) throws IOException {
        bw.write("#" + tc + " " + dist[n-1][n-1]);
        bw.newLine();
        bw.flush();
    }
}

class Point {
    int r, c, cost;

    Point(int r, int c, int cost) {
        this.r = r;
        this.c = c;
        this.cost = cost;
    }
}