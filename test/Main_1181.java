import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br; static BufferedWriter bw; static StringTokenizer st;

    static int n;
    static String[] arr;

    public static void main(String[] args) throws IOException {
        init();
        run();
        outprint();
    }

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine().trim());
        }

        arr = set.toArray(new String[0]);
    }

    static void run() throws IOException {
        Arrays.sort(arr, (a, b) -> {
            if(a.length() != b.length())
                return Integer.compare(a.length(), b.length());
            return a.compareTo(b);
        });
    }

    static void outprint() throws IOException {
        for(int i=0; i<arr.length; i++) 
            bw.write(arr[i] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}