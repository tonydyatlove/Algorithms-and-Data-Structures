import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("input.txt");
        Scanner scanner = new Scanner(fileReader);
        int number = scanner.nextInt();
        int[] size = new int[number + 1];
        for (int i = 0; i < number - 1; i++) {
            size[i] = scanner.nextInt();
            scanner.nextInt();
        }
        size[number - 1] = scanner.nextInt();
        size[number] = scanner.nextInt();
        int[][] multiply = new int[number][number];
        for (int k = 1; k < number; k++) {
            for (int j = 0; j < number - k; j++) {
                multiply[j][j + k] = Integer.MAX_VALUE;
                for (int m = j; m < (j + k); m++) {
                    multiply[j][j + k] = Math.min(multiply[j][j + k], multiply[j][m] + multiply[m + 1][j + k] + size[j] * size[m + 1] * size[j + k + 1]);
                }
            }
        }
        FileWriter fileWriter = new FileWriter("output.txt");
        fileWriter.write(multiply[0][number - 1] + "");
        fileWriter.close();
    }

}
