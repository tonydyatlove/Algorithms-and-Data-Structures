import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


class Tree {
    ArrayList<Integer> arrayList = new ArrayList<>();

    static class Node {
        Node left;
        Node right;
        int key;

        public Node(int key) {
            this.key = key;
        }
    }

    public Node point;

    public void inserted(int x) {
        point = insert(point, x);
    }

    public void leftOrder() {
        leftBypass(point);
    }

    public void deleted(int x) {
        point = delete(point, x);
    }

    public static Node insert (Node node, int key){
        if (node == null) {
            return new Node(key);
        }
        if (key < node.key) {
            node.left = insert(node.left, key);
        }
        if (key > node.key) {
            node.right = insert(node.right, key);
        }

        return node;
    }

    public void leftBypass(Node node) {
        if (node != null) {
            arrayList.add(node.key);
            if (node.left != null) {
                leftBypass(node.left);
            }
            if (node.right != null) {
                leftBypass(node.right);
            }
        }
    }

    public Node delete(Node node, int x) {
        if (node == null)
            return null;
            if (x < node.key) {
                node.left = delete(node.left, x);
                return node;
            }
            if (x > node.key) {
               node.right = delete(node.right, x);
               return node;
            }
        if (node.left == null)
            return node.right;
        if (node.right == null)
            return node.left;
        else {
            int min = findMin(node.right).key;
            node.key = min;
            node.right = delete(node.right, min);
            return node;
        }
    }

    public Node findMin(Node node){
        if (node.left != null)
            return findMin(node.left);
        else return node;
    }

}

public class Main implements Runnable {
    public static void main(String[] args) {
        new Thread(null, new Main(), "", 64 * 1024 * 1024).start();
    }

    public void run() {
        try {
            Tree tree = new Tree();
            int x;
            int delete_key = 0;

            FileReader fileReader = new FileReader("input.txt");
            Scanner scanner = new Scanner(fileReader);
            if (scanner.hasNext()) {
                delete_key = scanner.nextInt();
            }
            while (scanner.hasNext()) {
                x = scanner.nextInt();
                tree.inserted(x);
            }
            tree.deleted(delete_key);
            tree.leftOrder();
            FileWriter fileWriter = new FileWriter("output.txt");
            for (Integer i : tree.arrayList) {
                fileWriter.write(i + "\n");
            }
            fileWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
