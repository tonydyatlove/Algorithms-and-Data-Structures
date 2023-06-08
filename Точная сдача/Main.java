import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("input.txt");
        FileWriter fileWriter = new FileWriter("output.txt");
        Scanner scanner = new Scanner(fileReader);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int s = scanner.nextInt();
        int buyer_sum = 0;
        int[] M = new int[n + m];
        for (int i = 0; i < n; i++) {
            M[i] = scanner.nextInt();
            buyer_sum += M[i];
        }
        for (int i = n; i < n + m; i++) {
            M[i] = scanner.nextInt();
        }
        if (s > buyer_sum) {
            fileWriter.write("No");
            fileWriter.close();
        }
        else {
            int sum = 0;
            for (int i = 0; i < n + m; i++) {
                sum += M[i];
            }
            int[] exist = new int[sum + 1];
            exist[0] = 1;
            for (int i = 0; i < M.length; i++) {
                for (int j = sum - s - M[i]; j > -1; j--) {
                    if (exist[j] == 1) {
                        exist[j + M[i]] = 1;
                    }
                }
                if (exist[buyer_sum - s] == 1)
                    break;
            }
            if (exist[buyer_sum - s] == 1)
                fileWriter.write("Yes");
            else
                fileWriter.write("No");
            fileWriter.close();
        }
    }
}
