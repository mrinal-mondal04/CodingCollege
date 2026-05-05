import java.util.*;

public class One {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();

        // Double the string to simulate cyclic behavior
        String doubled = s + s;

        int[] freq = new int[26];
        int left = 0, maxSum = 0, currentSum = 0;

        for (int right = 0; right < 2 * n; right++) {
            char ch = doubled.charAt(right);
            int index = ch - 'a';

            // If duplicate found OR window size exceeds n, shrink window
            while (freq[index] > 0 || (right - left + 1) > n) {
                char leftChar = doubled.charAt(left);
                freq[leftChar - 'a']--;
                currentSum -= (leftChar - 'a' + 1);
                left++;
            }

            // Add current character
            freq[index]++;
            currentSum += (ch - 'a' + 1);

            // Update max sum
            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println(maxSum);
        sc.close();
    }
}