import java.util.*;

public class Two {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[] A = new long[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextLong();
        }

        long K = sc.nextLong();

        // Step 1: Check feasibility
        long remainder = A[0] % K;
        for (int i = 1; i < N; i++) {
            if (A[i] % K != remainder) {
                System.out.println(-1);
                return;
            }
        }

        // Step 2: Normalize values
        long base = A[0];
        long[] B = new long[N];

        for (int i = 0; i < N; i++) {
            B[i] = (A[i] - base) / K;
        }

        // Step 3: Sort and find median
        Arrays.sort(B);
        long median = B[N / 2];

        // Step 4: Calculate minimum operations
        long operations = 0;
        for (int i = 0; i < N; i++) {
            operations += Math.abs(B[i] - median);
        }

        System.out.println(operations);
        
    }

}
