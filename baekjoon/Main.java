import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static LinkedList<Integer> qu;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine().trim());
        qu = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            String command = st.nextToken();
            int x;
            if (st.hasMoreTokens()) {
                x = Integer.parseInt(st.nextToken());
                execute(command, x);
            } else
                execute(command);
        }
        // 출력
        bw.flush();
        br.close();
        bw.close();
    }

    static void execute(String cmd, int x) throws IOException {
        qu.offer(x);
    }

    static void execute(String cmd) throws IOException {
        switch (cmd) {
            case "pop": {
                bw.write((qu.isEmpty()) ? -1 + "\n" : qu.poll() + "\n");
                break;
            }
            case "size": {
                bw.write(qu.size() + "\n");
                break;
            }
            case "empty": {
                bw.write((qu.isEmpty()) ? 1 + "\n" : 0 + "\n");
                break;
            }
            case "front": {
                bw.write((qu.isEmpty()) ? -1 + "\n" : qu.peek() + "\n");
                break;
            }
            case "back": {
                bw.write((qu.isEmpty()) ? -1 + "\n" : qu.getLast() + "\n");
                break;
            }
        }

    }

}
