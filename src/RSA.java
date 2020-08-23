import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Represents a simple-to-use RSA implementation for test purposes.
 */
public class RSA {

    private static final SecureRandom rnd = new SecureRandom();

    private final BigInteger n;
    private final BigInteger decryptionKey;
    private final BigInteger encryptionKey;

    /**
     * Initializes a default RSA instance. Does not check if arguments are in fact prime!
     *
     * @param p The first prime number.
     * @param q The second prime number.
     */
    public RSA(int p, int q) {
        this(BigInteger.valueOf(p), BigInteger.valueOf(q));
    }

    /**
     * Initializes a default RSA instance. Does not check if arguments are in fact prime!
     *
     * @param p The first prime number.
     * @param q The second prime number.
     */
    public RSA(long p, long q) {
        this(BigInteger.valueOf(p), BigInteger.valueOf(q));
    }

    /**
     * Initializes a default RSA instance. Does not check if arguments are in fact prime!
     *
     * @param p The first prime number.
     * @param q The second prime number.
     */
    public RSA(BigInteger p, BigInteger q) {

        // phiN = (p-1)*(q-1)
        n = p.multiply(q);
        BigInteger phiN = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        encryptionKey = BigInteger.probablePrime(phiN.bitLength() - 1, rnd);
        System.out.println("encryptionKey " + encryptionKey);

        decryptionKey = calculateDecryptionKey(phiN, encryptionKey);
        System.out.println("decryptionKey: " + decryptionKey);
    }

    /**
     * My first try of implementing the euclidean algorithm.
     *
     * @param phiN          PhiN = (p-1) * (q-1)
     * @param encryptionKey Chose a prime number between 2 and phiN.
     * @return The decryption key is returned.
     */
    private static BigInteger calculateDecryptionKey(BigInteger phiN, BigInteger encryptionKey) {
        BigInteger sPrev = BigInteger.ONE;
        BigInteger sNext = BigInteger.ZERO;
        BigInteger tPrev = BigInteger.ZERO;
        BigInteger tNext = BigInteger.ONE;

        /* Calculate a and b from: 1 = a * phiN + b * encryptionKey.
           b is the decryptionKey. */
        BigInteger dividend = phiN;
        BigInteger divisor = encryptionKey;

        while (!dividend.mod(divisor).equals(BigInteger.ZERO)) {
            BigInteger lastQuotient = dividend.divide(divisor);

            BigInteger temp = sPrev;
            sPrev = sNext;
            sNext = temp.subtract(lastQuotient.multiply(sPrev));

            temp = tPrev;
            tPrev = tNext;
            tNext = temp.subtract(lastQuotient.multiply(tPrev));

            // Rest of division is new divisor.
            BigInteger oldCryptionKey = divisor;
            divisor = dividend.mod(divisor);
            dividend = oldCryptionKey;
        }

        // tNext is now our decryption key, which will need to be clamped to fit our algebraic ring.
        while (tNext.signum() < 0) {
            tNext = phiN.add(tNext);
        }
        return tNext.mod(phiN);
    }

    /**
     * Encrypts the given message using this RSA instance.
     *
     * @param message The message to encrypt.
     * @return The encrypted message.
     */
    public BigInteger encrypt(BigInteger message) {
        return message.modPow(encryptionKey, n);
    }

    /**
     * Decrypts the given message using this RSA instance.
     *
     * @param message The message to decrypt.
     * @return The decrypted message.
     */
    public BigInteger decrypt(BigInteger message) {
        return message.modPow(decryptionKey, n);
    }

}
