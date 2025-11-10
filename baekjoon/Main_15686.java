import java.util.*;
import java.io.*;

public class Main_15686 {
    static BufferedReader reader;
    static BufferedWriter writer;
    static StringTokenizer st;

    static int n, m, answer;
    static int[][] map;

    static List<Node> homes, chick;

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
        init();
        run();
        outprint();
    }

    static void init() throws IOException {
        st = new StringTokenizer(reader.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;
        map = new int[n][n];
        homes = new ArrayList<>();
        chick = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine().trim());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    homes.add(new Node(i, j));
                } else if (map[i][j] == 2) {
                    chick.add(new Node(i, j));
                }
            }
        }
    }

    static void run() throws IOException {
        comb(new ArrayList<>(), 0);
    }

    static void outprint() throws IOException {
        writer.write(String.valueOf(answer) + "\n");
        writer.flush();
    }

    static int getDist(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

    static void comb(List<Node> selected, int start) {
        if (selected.size() == m) {
            int cityDist = 0;
            for (Node home : homes) {
                int min = Integer.MAX_VALUE;
                for (Node chick : selected) {
                    int dist = getDist(home.x, home.y, chick.x, chick.y);
                    min = Math.min(min, dist);
                }
                cityDist += min;
            }
            answer = Math.min(answer, cityDist);
            return;
        }

        for (int i = start; i < chick.size(); i++) {
            selected.add(chick.get(i));
            comb(selected, i + 1);
            selected.remove(selected.size() - 1);
        }
    }
}