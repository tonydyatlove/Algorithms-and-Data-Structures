import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static class dv{
        public int v;
        public long weight;

        public dv(long weight, int v) {
            this.v = v;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        FileReader fr =new FileReader("input.txt");
        FileWriter fw = new FileWriter("output.txt");
        BufferedReader df = new BufferedReader(fr);
        String data [] = df.readLine().split(" ");
        int n, m;
        n = Integer.parseInt(data[0]);
        m = Integer.parseInt((data[1]));
        if (n == m && n == 0){
            fw.write("0");
            fw.close();
        }
        else{
            ArrayList<ArrayList<dv>> g = new ArrayList<>();

            boolean [] proceeded = new boolean[n];
            long [] dist = new long[n];
            for (int i = 0; i<n; i++){
                g.add(new ArrayList<>());
                dist[i] = Long.MAX_VALUE;
            }
            for(int i = 0; i< m; i++)
            {
                data = df.readLine().split(" ");
                int v, u;
                long c;
                v = Integer.parseInt(data[0]);
                u = Integer.parseInt(data[1]);
                c = Long.parseLong(data[2]);
                if (v!=u) {
                    g.get(v-1).add(new dv(c, u));
                    g.get(u-1).add(new dv(c, v));
                }

            }
            Comparator<dv> comparator = Comparator.comparingLong(o -> o.weight);
            PriorityQueue<dv> q = new PriorityQueue<>(comparator);
            q.add(new dv(0,1));
            dist[0] = 0;
            while(!q.isEmpty()) {
                int v;
                long dv;
                dv tmp = q.poll();
                dv = tmp.weight;
                v = tmp.v;
                if (proceeded[v - 1]) continue;
                proceeded[v - 1] = true;
                dist[v - 1] = dv;
                for (dv rebro : g.get(v - 1)) {
                    if (!proceeded[rebro.v - 1] && dv + rebro.weight < dist[rebro.v - 1])
                        q.add(new dv(dv + rebro.weight, rebro.v));

                }
            }fw.write(String.valueOf(dist[dist.length-1]));
            fw.close();
        }
    }
}
