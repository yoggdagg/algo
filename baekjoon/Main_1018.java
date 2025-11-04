import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n, m, result;

    static int[][] board;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        result = Integer.MAX_VALUE;
        board = new int[n][m];

        for(int i=0; i<n; i++) {
            String line = br.readLine().trim();
            for(int j=0; j<m; j++) {
                if(line.charAt(j) == 'W')
                    board[i][j] = 0;
                else
                    board[i][j] = 1;
            }
        }

        for(int i=0; i<=n-8; i++) {
            for(int j=0; j<=m-8; j++) {
                int cnt = 0;
                int sr = i; int sc = j;
                int startPoint = board[sr][sc];
                for(int r=sr; r<sr+8; r++) {
                    for(int c=sc; c<sc+8; c++) {
                        if((r + c) % 2 == (sr + sc) % 2) {
                            if(board[r][c] != startPoint)
                                cnt++;
                        } else {
                            if(board[r][c] == startPoint)
                                cnt++;
                        }
                    }
                }
                cnt = Math.min(cnt, 64 - cnt);
                result = Math.min(result, cnt);
            }
        }
        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();
    }
}