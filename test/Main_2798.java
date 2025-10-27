import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n, m;
    static int[] arr;

    static boolean[] visited;

    static int result;

    public static void main(String[] args) throws IOException {
        init();
        run();
        outprint();
    }

    static void init() throws IOException {
        // Initialization code here
        st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];
        result = 0;

        st = new StringTokenizer(br.readLine().trim());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
    static void run() throws IOException {
        // Main logic here
        combination(0, 0, 3);
    }

    static void outprint() throws IOException {
        // Output code here
        bw.write(String.valueOf(result));
        bw.flush();
    }

    static void combination(int start, int depth, int r) throws IOException {
        if(depth == r) {
            int sum = 0;
            for(int i=0; i<n; i++) {
                if(visited[i]) {
                    sum += arr[i];
                }
            }
            if(sum <= m && m - sum < m - result) {
                result = sum;
            }
            return;
        }

        for(int i=start; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                combination(i, depth+1, r);
                visited[i] = false;
            }
        }
    }
}
