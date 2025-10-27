import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;

    static int[] arr;

    static int x, y;
    public static void main(String[] args) throws IOException {
        init();
        run();
        outprint();
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine().trim());
        arr = new int[6];
        for(int i=0; i<6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void run() throws IOException {
        int a = arr[0]; int b = arr[1]; int c = arr[2]; int d = arr[3]; int e = arr[4]; int f = arr[5];
        if(a == 0) {
            y = c/b;
            x = (f - e*y)/d;
            return;
        }
        y = (c*d -a*f)/(b*d - a*e);
        x = (c - b*y)/a;
    }

    static void outprint() throws IOException {
        bw.write(x + " " + y);
        bw.flush();
    }
}