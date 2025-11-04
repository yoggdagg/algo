import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n;
    public static void main(String[] args) throws IOException {
        init();
        outprint();
    }

    static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
    }

    static int run() throws IOException {
        int num = 666;
        int cnt = 1;

        while(cnt != n) {
            num++;
            if(String.valueOf(num).contains("666")) {
                cnt++;
            }
        }



        return num;
    }

    static void outprint() throws IOException {
        bw.write(String.valueOf(run()));
        bw.flush();
        bw.close();
        br.close();
    }
}