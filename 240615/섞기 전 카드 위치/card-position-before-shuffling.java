import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;

    static Map<Integer, Integer> map = new HashMap<>();
    static int[] cards;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        cards = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            map.put(Integer.parseInt(st.nextToken()), i);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= 3; i++) {
            int[] temp = cards.clone();
            for (int j = 1; j <= N; j++) {
                temp[j] = cards[map.get(j)];
            }
            cards = temp;
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            answer.append(cards[i]).append("\n");
        }
        System.out.println(answer);
    }
}