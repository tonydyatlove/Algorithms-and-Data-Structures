import java.util.ArrayDeque;
import java.util.Scanner;

public class Frog {
    public static void main(String[] args) {
            ArrayDeque<Integer> number = new ArrayDeque<>();
            Scanner scanner = new Scanner(System.in);
            int amount = scanner.nextInt();
            int[] mosquito = new int[amount];

            for (int i = 0; i < amount; i++) {
                mosquito[i] = scanner.nextInt();
            }
            int dp[] = new int[amount];
            dp[0] = mosquito[0];
            if (amount >= 2) {
                dp[1] = -1;
            }
            if (amount >= 3) {
                dp[2] = dp[0] + mosquito[2];
            }
            for (int i = 3; i < amount; i++) {
                dp[i] = Math.max(dp[i - 2], dp[i - 3]) + mosquito[i];
            }
            System.out.print(dp[amount - 1] + "\n");
            if (amount == 1) {
                number.addFirst(amount);
                while (number.size() != 0) {
                    System.out.print(number.poll() + " ");
                }
            }
            if (amount == 3) {
                number.addFirst(amount);
                number.addFirst(amount - 2);
                while (number.size() != 0) {
                    System.out.print(number.poll() + " ");
                }
            }
            if (amount > 3) {
                int j = amount - 1;
                number.addFirst(amount);
                while (j >= 2) {
                    if (j == 2 || dp[j - 2] > dp[j - 3]) {
                        j = j - 2;
                    } else {
                        j = j - 3;
                    }
                    number.addFirst(j + 1);
                }
            }
            while (number.size() != 0) {
                System.out.print(number.poll() + " ");
            }
    }
}
