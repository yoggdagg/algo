import java.util.*;
import java.io.*;

public class Main_2839 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int sum;
    public static void main(String[] args) throws IOException {
        init();
        run();
        outprint();
    }

    static void init() throws IOException {
        // Initialization code here
        n = Integer.parseInt(br.readLine().trim());
    }

    static void run() throws IOException {
        // Main logic here
        int a3 = 0; int a5 = 0;
        a5 = n / 5;
        a3 = (n - 5 * a5) / 3;
        while(!(5 * a5 + 3 * a3 == n) && a5 > 0) {
            a5--;
            a3 = (n - 5 * a5) / 3;
        }

        sum = a3 + a5;
        if(5 * a5 + 3 * a3 != n) 
            sum = -1;
    }

    static void outprint() throws IOException {
        // Output code here
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
        br.close();
    }
}