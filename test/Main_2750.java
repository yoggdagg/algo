import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br; static BufferedWriter bw; static StringTokenizer st;

    static int n;
    static Integer[] arr;

    public static void main(String[] args) throws IOException {
        init();
        run();
        outprint();
    }

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine().trim());
        arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine().trim());
        }
    }

    static void run() throws IOException {
        Arrays.sort(arr);
    }

    static void outprint() throws IOException {
        for(int i : arr)
            bw.write(String.valueOf(i) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}