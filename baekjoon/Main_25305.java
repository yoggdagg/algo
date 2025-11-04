import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br; static BufferedWriter bw; static StringTokenizer st;

    static int n, k;
    static Integer[] arr;

    public static void main(String[] args) throws IOException {
        init();
        run();
        outprint();
    }

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine().trim());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new Integer[n];

        st = new StringTokenizer(br.readLine().trim());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void run() throws IOException {
        Arrays.sort(arr, Collections.reverseOrder());
    }

    static void outprint() throws IOException {
        bw.write(String.valueOf(arr[k-1]));
        bw.flush();
        bw.close();
        br.close();
    }
}