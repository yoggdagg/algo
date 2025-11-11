import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br; static BufferedWriter bw; static StringTokenizer st;

    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        init();
        run();
        ourprint();
    }

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine().trim());
        arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine().trim());
        }
    }

    static void run() throws IOException {
        Arrays.sort(arr);
    }

    static void ourprint() throws IOException {
        for(int i=0; i<arr.length; i++) 
            bw.write(String.valueOf(arr[i] +  "\n"));
        bw.flush();
        bw.close();
        br.close();
    }

    static int[] reverse(int[] arr) {
        int[] temp = new int[arr.length];

        for(int i=0; i< (arr.length/2); i++) {
            temp[i] = arr[arr.length-1-i];
            temp[arr.length-1-i] = arr[i];
        }

        return temp;
    }
}