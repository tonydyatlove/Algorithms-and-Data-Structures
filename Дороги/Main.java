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
        return parent[k - 1] = Find(parent[k - 1]);
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfCities = scanner.nextInt();
        int numOfWays = scanner.nextInt();
        int[][] roads_to_be_destroyed = new int[numOfWays][2];
        Main main = new Main(numOfCities);
        int request1, request2;
        boolean f = false;
        for (int i = 0; i < numOfWays; i++) {
            request1 = scanner.nextInt();
            request2 = scanner.nextInt();
            roads_to_be_destroyed[i][0] = request1;
            roads_to_be_destroyed[i][1] = request2;
        }
        char[] result = new char[numOfWays];
        for (int k = numOfWays - 1; k > -1; k--) {
            if (main.counter > 1) {
                main.Union(roads_to_be_destroyed[k][0], roads_to_be_destroyed[k][1]);
                result[k] = '0';
            }
            else {
                result[k] = '1';
                break;
            }
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] == '0') {
                System.out.println(i + 1 + "");
                break;
            }
        }
    }
}
