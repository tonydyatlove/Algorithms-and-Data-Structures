import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("input.txt");
        FileWriter fileWriter = new FileWriter("output.txt");
        Scanner scanner = new Scanner(fileReader);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[] dp = new int[n];
        int[] num = new int[n];
        boolean zero_check = false;
        int zero_i = 0;
        for (int i = 0; i < n; i++) {
            num[i] = Math.abs(scanner.nextInt());
            if (num[i] == 0) {
                zero_check = true;
                zero_i++;
            }
            dp[i] = 1;
        }
        Arrays.sort(num);
        if (zero_i == n && n!=0) {
            fileWriter.write(1 + "");
            fileWriter.close();
        }
        else if(n==0) {
            fileWriter.write(0 + "");
            fileWriter.close();
        }
        else
        {
            int max_len = 0;
            for (int i = zero_i; i < n; i++) {
                max_len = 0;
                for (int j = zero_i; j < i; j++) {

                    if (num[i] % num[j] == 0) {
                        if (dp[j] + 1 > max_len) {
                            max_len = dp[j] + 1;

                        }
                    }
                }
                if (dp[i] < max_len) {
                    dp[i] = max_len;
                }
            }
            int maxim = 0;
            for (int j = 0; j < n; j++) {
                if (dp[j] > maxim) {
                    maxim = dp[j];
                }
            }
            if (zero_check)
                maxim = maxim + 1;
            fileWriter.write(maxim + "");
            fileWriter.close();
        }

    }
}
