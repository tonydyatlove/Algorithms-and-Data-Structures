import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private int[] parent;
    private int[] size;
    private int counter;

    Main(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i + 1;
            size[i] = 1;
        }
        counter = n;
    }

    int Find(int k) {
        if (parent[k - 1] == k) {
            return k;
        }
        return parent[k - 1] = Find(parent[k-1]);
    }

    void Union(int a, int b) {
        int x = Find(a);
        int y = Find(b);
        if (x != y) {
            if (size[x - 1] < size[y - 1]) {
                int tmp = x;
                x = y;
                y = tmp;
            }
            parent[y - 1] = x;
            size[x - 1] += size[y - 1];
            counter--;
        }
    }

    int getCounter() {
        return counter;
    }

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("input.txt");
        FileWriter fileWriter = new FileWriter("output.txt");
        BufferedReader scanner = new BufferedReader(fileReader);
        String []data= scanner.readLine().split(" ");
        int numOfCities = Integer.parseInt(data[0]);
        int numOfRequests = Integer.parseInt(data[1]);
        Main main = new Main(numOfCities);
        int request1, request2;
        for (int i = 0; i < numOfRequests; i++) {
            data = scanner.readLine().split(" ");
            request1 = Integer.parseInt(data[0]);
            request2 = Integer.parseInt(data[1]);
            main.Union(request1, request2);
            fileWriter.write(main.getCounter() + "\n");
        }
        fileWriter.close();
    }
}
