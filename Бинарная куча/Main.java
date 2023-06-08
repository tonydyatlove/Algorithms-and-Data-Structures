import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader("input.txt");
        FileWriter fileWriter = new FileWriter("output.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            int n = Integer.parseInt(bufferedReader.readLine());
            int[] mas = new int[n + 1];
            mas[0] = Integer.MIN_VALUE;
            String[] data = bufferedReader.readLine().split(" ");
            for (int i = 1; i <= n; i++) {
                mas[i] = Integer.parseInt(data[i - 1]);
            }
            int m;
            boolean is_heap = true;
            boolean is_even = false;
            if ((n + 1) % 2 == 1)
                m = (n + 1) / 2;
            else {
                m = (n + 1) / 2;
                is_even = true;
            }
            for (int i = 1; i <= m; i++) {
                if (i == m && !is_even) {
                    if (!(mas[2 * i] >= mas[i])) {
                        is_heap = false;
                        break;
                    }
                } else if (i == m && is_even) {
                    break;
                } else {
                    if (!(mas[2 * i] >= mas[i] && mas[2 * i + 1] >= mas[i])) {
                        is_heap = false;
                        break;
                    }
                }
            }
            if (is_heap) bufferedWriter.write("Yes");
            else bufferedWriter.write("No");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
