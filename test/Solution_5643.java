import java.util.*;
import java.io.*;

public class Solution_5643 {
    static BufferedReader br; static BufferedWriter bw; static StringTokenizer st;
    
    static int n, m, cnt;
    static List<ArrayList<Integer>> smaller, taller;
    static boolean[] visited;
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
    }

    static void init() throws IOException {
        n = Integer.parseInt(br.readLine().trim());
        m = Integer.parseInt(br.readLine().trim());

        smaller = new ArrayList<>();
        taller = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            smaller.add(new ArrayList<>());
            taller.add(new ArrayList<>());
        }
        
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            smaller.get(b).add(a);
            taller.get(a).add(b);
        }
    }

    static int run() throws IOException {
        int result = 0;
        for(int i=1; i<=n; i++) {
            cnt = 0;
            visited = new boolean[n+1];
            dfs(i, smaller);
            int smallerCnt = cnt;

            cnt = 0;
            visited = new boolean[n+1];
            dfs(i, taller);
            int tallerCnt = cnt;

            if( smallerCnt + tallerCnt == n-1) 
                result++;
        }

        return result;
    }

    static void dfs(int cur, List<ArrayList<Integer>> graph) {
        visited[cur] = true;

        for(int next : graph.get(cur)) {
            if(!visited[next]) {
                cnt++;
                dfs(next, graph);
            }
        }
    }
 
    static void outprint(int tc) throws IOException {
        bw.write("#" + tc + " " + run() + "\n");
        bw.flush();
    }
}