import java.util.*;
import java.io.*;

public class Solution_1949 {
    static BufferedReader br; static BufferedWriter bw; static StringTokenizer st;

    static int n, k, max, length;
    static int[][] graph;
    static int[] dx = { 0, 0, -1, 1};
    static int[] dy = { -1, 1, 0, 0};

    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
       // br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        br = new BufferedReader(new FileReader("./input.txt"));

        int t = Integer.parseInt(br.readLine().trim());
        for(int tc=1; tc<t; tc++) {
            init();
            run();
            outprint(tc);
        }
        

    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        max = 0;

        graph = new int[n][n];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for(int j=0; j<n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, graph[i][j]);
            }
        }
    }

    static void run() throws IOException {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(graph[i][j] == max) {
                    visited = new boolean[n][n];
                    bfs(new int[] {i, j}, false);
                }
            }
        }
    }

    static void outprint(int tc) throws IOException{
        bw.write(String.valueOf(length));
        bw.flush();
    }

    static void bfs(int[] arr, boolean used) {
        Queue<int[]> qu = new LinkedList<>();
        qu.offer(arr);
        length = 1;

        while(!qu.isEmpty()) {
            int[] point = qu.poll();
            int curR = point[0], curC = point[1], curValue = graph[curR][curC];
            visited[curR][curC] = true;
            for(int d=0; d<4; d++) {
                int nextR = curR + dx[d];
                int nextC = curC + dy[d];

                if(nextR<0 || n<=nextR || nextC<0 || n<=nextC || visited[nextR][nextC]) 
                    continue;
                
                int nextValue = graph[nextR][nextC];
                if(nextValue-k< curValue && !used) {
                    graph[nextR][nextC] = curValue - 1;
                    length++;
                    qu.offer(new int[]{nextR, nextC});
                }
            }
        }
    }
}