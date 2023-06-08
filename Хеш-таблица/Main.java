import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("input.txt");
        FileWriter fileWriter = new FileWriter("output.txt");
        Scanner scanner = new Scanner(fileReader);
        int m = scanner.nextInt();
        int c = scanner.nextInt();
        int n = scanner.nextInt();
        int[] keys = new int[m];
        for (int i = 0; i < m; i++) {
            keys[i] = -1;
        }
        int h = 0;
        for (int k = 0; k < n; k++) {
            int x = scanner.nextInt();
            for (int i = 0; i < m; i++) {
                h = ((x % m) + c * i) % m;
                if (keys[h] == -1) {
                    keys[h] = x;
                    break;
                }
                else if (keys[h] == x)
                    break;
            }
        }
        for (int k = 0; k < m; k++) {
            fileWriter.write(keys[k] + " ");
        }
        fileWriter.close();
    }
}
