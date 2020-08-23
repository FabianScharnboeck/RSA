import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        BigInteger result = RSA.calculateDecryptionKey(BigInteger.valueOf(648), BigInteger.valueOf(11));
        System.out.println(result);
    }
}
