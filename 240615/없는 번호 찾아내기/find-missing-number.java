import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static boolean[] arr = new boolean[31];

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 28; i++) {
            arr[Integer.parseInt(br.readLine())] = true;
        }
        int min = Integer.MAX_VALUE;
        int max = -1;
        for (int i = 1; i <= 30; i++) {
            if(!arr[i]) {
                min = Math.min(min, i);
                max = Math.max(i, min);
            }
        }
        System.out.println(min + "\n" + max);
    }
}