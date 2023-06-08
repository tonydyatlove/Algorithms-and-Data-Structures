import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("input.txt");
        FileWriter fileWriter = new FileWriter("output.txt");
        Scanner scanner = new Scanner(fileReader);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int next_index = 1;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int[] ord = new int[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                deque.add(i);
                visited[i] = true;
                while (!deque.isEmpty()) {
                    int v = deque.poll();
                    ord[v] = next_index;
                    next_index += 1;
                    for (int u = 0; u < matrix[v].length; u++) {
                        if (matrix[v][u] == 1) {
                            if (!visited[u]) {
                                deque.add(u);
                                visited[u] = true;
                                //ord[u] = next_index;
                                //next_index += 1;
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < ord.length; i++) {
            fileWriter.write(ord[i] + " ");
        }
        fileWriter.close();
    }
}
