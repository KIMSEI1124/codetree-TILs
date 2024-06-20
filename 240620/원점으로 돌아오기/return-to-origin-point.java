import java.util.*;
import java.io.*;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static Pos[] arr;

    static int answer;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new Pos[N + 1];
        arr[0] = new Pos(0, 0);
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
    }

    static void solve() {
        dfs(0, 0, new boolean[N + 1]);
    }
    
    static void dfs(int index, int count, boolean[] visited) {
        if (count == N && index == 0) {
            answer++;
            return;
        }

        for (int i = 0; i <= N; i++) {
            if (!visited[i]) {
                if (arr[i].x == arr[index].x) {
                    dfs(i, count + 1, copy(visited, i));
                }
                if (arr[i].y == arr[index].y) {
                    dfs(i, count + 1, copy(visited, i));
                }
            }
        }
    }

    static boolean[] copy(boolean[] v, int i) {
        boolean[] temp = v.clone();
        temp[i] = true;
        return temp;
    }

    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}