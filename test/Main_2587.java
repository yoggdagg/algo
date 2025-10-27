import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br; static BufferedWriter bw; static StringTokenizer st;

    static Integer[] arr;
    static int avg, mid;

    public static void main(String[] args) throws IOException {
        init();
        run();
        outprint();
    }

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        arr = new Integer[5];
        
        for(int i=0; i<5; i++) {
            arr[i] = Integer.parseInt(br.readLine().trim());
        }

        Arrays.sort(arr);
    }

    static void run() throws IOException {
        int sum = 0;
        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
        }
        avg = sum / arr.length;
        mid = arr[arr.length / 2];
    }

    static void outprint() throws IOException {
        bw.write(String.valueOf(avg) + "\n");
        bw.write(String.valueOf(mid) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}