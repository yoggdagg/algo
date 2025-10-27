import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br; static BufferedWriter bw; static StringTokenizer st;

    static int[][] arr;
    public static void main(String[] args) throws IOException {
        init();
        run();
        outprint();
    }
    
    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine().trim());
        arr = new int[n][2];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    static void run() throws IOException {
        Arrays.sort(arr, (a, b) -> {
            if(a[1] != b[1]) 
                return Integer.compare(a[1], b[1]);
            
            return Integer.compare(a[0], b[0]);
        });
    }

    static void outprint() throws IOException {
        for(int i=0; i<arr.length; i++) 
            bw.write(arr[i][0] + " "  + arr[i][1] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

}