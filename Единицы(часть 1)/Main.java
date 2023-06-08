import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int p = 1000000007;
        BigInteger x = (factorial(n).divide(factorial(k)).divide(factorial(n - k)));
        System.out.println(x.mod(BigInteger.valueOf(p)));
    }
    public static BigInteger factorial (int a) {
        BigInteger fact = BigInteger.ONE;
        for (int i = 1; i <= a; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        return fact;
    }
}
