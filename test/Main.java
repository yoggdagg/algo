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
        arr = new int[n];

        st = new StringTokenizer(br.readLine().trim());
        for(int i=0; i<n; i++) 
            arr[i] = Integer.parseInt(st.nextToken());
    }

    static void run() throws IOException {
        int[] temp = arr.clone();
        Arrays.sort(temp);

        Map<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for(int num : temp) {
            if(!map.containsKey(num)) {
                map.put(num, idx++);
            }
        }

        for(int i=0; i<n; i++) 
            arr[i] = map.get(arr[i]);
  
    }

    static void outprint() throws IOException {
        for(int i : arr) 
            bw.write(i + " " );
        bw.flush();
        bw.close();
        br.close();
    }
}