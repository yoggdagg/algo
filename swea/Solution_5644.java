import java.util.*;
import java.io.*;

public class Solution_5644 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static int[] dy = { 0, -1, 0, 1, 0 };
    static int[] dx = { 0, 0, 1, 0, -1 };

    static int time, apCnt;
    static int[] moveA, moveB;
    static int[][] BC;
    static int answer;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        br = new BufferedReader(new FileReader("./input.txt"));

        int t = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= t; tc++) {
            init();
            run();
            outprint(tc);
        }
        br.close();
        bw.close();
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine().trim());
        time = Integer.parseInt(st.nextToken());
        apCnt = Integer.parseInt(st.nextToken());

        moveA = new int[time + 1];
        moveB = new int[time + 1];

        st = new StringTokenizer(br.readLine().trim());
        for (int i = 1; i <= time; i++)
            moveA[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine().trim());
        for (int i = 1; i <= time; i++)
            moveB[i] = Integer.parseInt(st.nextToken());

        BC = new int[apCnt][4];
        for (int i = 0; i < apCnt; i++) {
            st = new StringTokenizer(br.readLine().trim());
            BC[i][0] = Integer.parseInt(st.nextToken());
            BC[i][1] = Integer.parseInt(st.nextToken());
            BC[i][2] = Integer.parseInt(st.nextToken());
            BC[i][3] = Integer.parseInt(st.nextToken());

        }

        answer = 0;
    }

    static void run() {
        int ax = 1, ay = 1;
        int bx = 10, by = 10;

        for (int i = 0; i <= time; i++) {
            ax += dx[moveA[i]];
            ay += dy[moveA[i]];
            bx += dx[moveB[i]];
            by += dy[moveB[i]];

            // i초 일 때 충전량을 구해서 answer에 누적
            answer += charge(ax, ay, bx, by);
        }
    }

    static void outprint(int tc) throws IOException {
        bw.write("#" + tc + " " + answer + "\n");
        bw.flush();
    }

    static boolean inRange(int x, int y, int[] bc) {
        return Math.abs(x - bc[0]) + Math.abs(y - bc[1]) <= bc[2];
    }

    static int charge(int ax, int ay, int bx, int by) {
        int max = 0;
        for (int i = 0; i < apCnt; i++) {
            int aP = inRange(ax, ay, BC[i]) ? BC[i][3] : 0;
            for (int j = 0; j < apCnt; j++) {
                int bP = inRange(bx, by, BC[j]) ? BC[j][3] : 0;
                int sum;
                if (i == j) {
                    sum = Math.max(aP, bP); // 같은 AP에서는 한 명만 사용
                } else {
                    sum = aP + bP;
                }
                max = Math.max(max, sum);
            }
        }
        return max;
    }

}

class AP {
    int x, y, c, p;

    AP(int x, int y, int c, int p) {
        this.x = x;
        this.y = y;
        this.c = c;
        this.p = p;
    }
}