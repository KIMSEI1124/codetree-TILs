import java.io.*;
import java.util.*;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static PriorityQueue<Word> pq = new PriorityQueue<>();
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.add(new Word(br.readLine()));
        }
    }

    static void solve() {
        while (!pq.isEmpty()) {
            answer.append(pq.poll().s).append("\n");
        }
    }

    static class Word implements Comparable<Word> {
        
        final String s;

        public Word(String s) {
            this.s = s;
        }

        @Override
        public int compareTo(Word other) {
            if (s.length() < other.s.length()) {
                return -1;
            }
            if (s.length() == other.s.length()) {
                return s.compareTo(other.s);
            }
            return 1;
        }
    }
}