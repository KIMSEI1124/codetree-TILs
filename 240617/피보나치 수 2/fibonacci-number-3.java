import java.io.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final long MOD = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        System.out.println(fibonacci(n));
    }

    public static long fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        
        long[][] result = {{1, 0}, {0, 1}};
        long[][] fibMatrix = {{1, 1}, {1, 0}};
        
        n -= 1;
        while (n > 0) {
            if (n % 2 == 1) {
                result = matrixMultiply(result, fibMatrix);
            }
            fibMatrix = matrixMultiply(fibMatrix, fibMatrix);
            n /= 2;
        }
        
        return result[0][0];
    }

    private static long[][] matrixMultiply(long[][] a, long[][] b) {
        return new long[][] {
            {(a[0][0] * b[0][0] + a[0][1] * b[1][0]) % MOD, (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % MOD},
            {(a[1][0] * b[0][0] + a[1][1] * b[1][0]) % MOD, (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % MOD}
        };
    }
}