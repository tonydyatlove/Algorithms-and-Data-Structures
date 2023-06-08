import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        BigInteger p = BigInteger.valueOf(1000000007);
        BigInteger h = p.subtract(BigInteger.valueOf(2));
        if (k == n || k == 0) {
            System.out.println("1");
        }
        else if (n - k == 1) {
            System.out.println(n);
        }
        else {
            BigInteger x = (factorial1(n, k, p).mod(p).multiply(pow(factorial2(n, k, p), h, p)).mod(p)).mod(p);
            System.out.println(x);
        }
    }
    public static BigInteger factorial1 (int n, int k, BigInteger p) {
        BigInteger fact = BigInteger.ONE;
        for (int i = k + 1; i <= n; i++) {
            fact = ((fact.mod(p).multiply(BigInteger.valueOf(i)).mod(p))).mod(p);
        }
        return fact;
    }

    public static BigInteger factorial2 (int n, int k, BigInteger p) {
        BigInteger fact2 = BigInteger.ONE;
        for (int i = 1; i <= n - k; i++) {
            fact2 = (fact2.mod(p).multiply(BigInteger.valueOf(i)).mod(p)).mod(p);
        }
        return fact2;
    }

    public static BigInteger pow (BigInteger a, BigInteger b, BigInteger mod){
        BigInteger c = BigInteger.ONE;
        while (b.compareTo(BigInteger.valueOf(0)) > 0) {
            if (b.mod(BigInteger.valueOf(2)).equals(BigInteger.ONE)) {
                c = (a.mod(mod).multiply(c).mod(mod)).mod(mod);
            }
            a = (a.mod(mod).multiply(a).mod(mod)).mod(mod);
            b = b.divide(BigInteger.valueOf(2));
        }
        return c;
    }
}
