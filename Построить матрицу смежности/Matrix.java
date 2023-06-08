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
        int m = scanner.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 0;
            }
        }
        int u, v;
        for (int i = 0; i < m; i++) {
            u = scanner.nextInt();
            v = scanner.nextInt();
            matrix[u - 1][v - 1] = 1;
            matrix[v - 1][u - 1] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                fileWriter.write(matrix[i][j] + " ");
            }
            fileWriter.write("\n");
        }
        fileWriter.close();
    }
}
