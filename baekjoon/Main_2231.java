import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    public static void main(String[] args) throws IOException {
        init();
        outprint();
    }

    static void init() throws IOException {
        n = Integer.parseInt(br.readLine().trim());
    }

    static int run() throws IOException {
        int m = 1;
        while(m < n && !check(m)) {
            m++;
        }
        if(m == n) 
            return 0;
            
        return m;
    }

    static void outprint() throws IOException {
        bw.write(String.valueOf(run()));
        bw.flush();
     }

     static boolean check(int m) {
        String str = Integer.toString(m);
        int sum = m;
        for(int i=0; i<str.length(); i++) {
            sum += str.charAt(i) - '0';
        }

        if(sum == n)
            return true;
        
        return false;
     }
}