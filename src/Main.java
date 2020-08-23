import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        RSA rsa = new RSA(BigInteger.valueOf(367), BigInteger.valueOf(139));
        System.out.println("Message to encrypt: 2300");
        System.out.println("Encryption: " + rsa.encrypt(BigInteger.valueOf(2300)));
        System.out.println("Decryption: " + rsa.decrypt(rsa.encrypt(BigInteger.valueOf(2300))));
    }
}
