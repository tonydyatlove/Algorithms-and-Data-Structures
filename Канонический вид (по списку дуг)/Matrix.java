import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("input.txt");
        FileWriter fileWriter = new FileWriter("output.txt");
        Scanner scanner = new Scanner(fileReader);
        int n = scanner.nextInt();
        int[] matrix = new int[n];
        for (int i = 0; i < n; i++) {
            matrix[i] = 0;
        }
        int u, v;
        for (int i = 0; i < n - 1; i++) {
            u = scanner.nextInt();
            v = scanner.nextInt();
            matrix[v - 1] = u;
        }
        for (int i = 0; i < n; i++) {
            fileWriter.write(matrix[i] + " ");
        }
        fileWriter.close();
    }
}
