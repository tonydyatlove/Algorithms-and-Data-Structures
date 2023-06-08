import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("input.txt");
        FileWriter fileWriter = new FileWriter("output.txt");
        Scanner scanner = new Scanner(fileReader);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer> arrayList[] = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            arrayList[i] = new ArrayList<Integer>();
        }
        int u, v;
        for (int i = 0; i < m; i++) {
            u = scanner.nextInt();
            v = scanner.nextInt();
            arrayList[u - 1].add(v);
            arrayList[v - 1].add(u);

        }
        for (ArrayList<Integer> integers : arrayList) {
            fileWriter.write(integers.size() + " ");
            for (Integer l : integers) {
                fileWriter.write(l + " ");
            }
            fileWriter.write("\n");
        }
        fileWriter.close();
    }
}
