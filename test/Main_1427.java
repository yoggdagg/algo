import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br; static BufferedWriter bw; static StringTokenizer st;

    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        init();
        run();
        outprint();
    }

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine().trim());
        arr = new int[String.valueOf(n).length()];
    }

    static void run() throws IOException {
        String num = String.valueOf(n);
        for(int i=0; i<arr.length; i++) {
            arr[i] = num.charAt(i) - '0';
        }

        Arrays.sort(arr);

        reverse(arr);
    }

    static void outprint() throws IOException {
        for(int i=0; i<arr.length; i++) 
            bw.write(String.valueOf(arr[i]));
        bw.flush();
        bw.close();
        br.close();
    }

    static void reverse(int[] arr) {
        for(int i=0; i<(arr.length/2); i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length -1 -i];
            arr[arr.length-1 - i] = temp;
        }
    }
}