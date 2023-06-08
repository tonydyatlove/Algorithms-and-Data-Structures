import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static int n;
    public static int[][] matrix;
    public static int[] ord;
    public static int counter = 1;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("input.txt");
        FileWriter fileWriter = new FileWriter("output.txt");
        Scanner scanner = new Scanner(fileReader);
        n = scanner.nextInt();
        matrix = new int[n][n];
        ord = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            visited[i] = true;
        }
        while (true) {
            int next = -1;
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    next = i;
                    break;
                }
            }
            if (next != -1) {
                dfs(next);
            }
            else break;
        }
        for (int i = 0; i < n; i++) {
            fileWriter.write(ord[i] + " ");
        }
        fileWriter.close();
    }

    public static void dfs (int index) {
        ord[index] = counter;
        counter += 1;
        visited[index] = false;
        for (int i = 0; i < n; i++) {
            if (matrix[index][i] == 1) {
                if (visited[i]) {
                    dfs(i);
                }
            }
        }
    }
}
