import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class RSA {

    private BigInteger p,q;
    private BigInteger phiN;
    private BigInteger N;
    public BigInteger encryptionKey;

    public RSA(BigInteger p, BigInteger q) {
        this.p = p;
        this.q = q;
        N = p.multiply(q);
        // phiN = (p-1)*(q-1)
        phiN = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));


    }

    /**
     * My first try of implementing the euclidean algorithm.
     * @param phiN
     * @param encryptionKey
     * @return The decryption key is returned.
     */
    public static BigInteger calculateDecryptionKey(BigInteger phiN, BigInteger encryptionKey) {
        List<BigInteger> quotient = new ArrayList<>();
        List<BigInteger> rest = new ArrayList<>();
        List<BigInteger> s = new ArrayList<>();
        s.add(BigInteger.ONE);
        s.add(BigInteger.ZERO);
        List<BigInteger> t = new ArrayList<>();
        t.add(BigInteger.ZERO);
        t.add(BigInteger.ONE);

        /**
         * calculate a and b from: 1 = a * phiN + b*encryptionKey.
         * b is the decryptionKey.
         */
        BigInteger dividend = phiN;
        BigInteger divisor = encryptionKey;
        while(!(dividend.mod(divisor).equals(BigInteger.ZERO))) {

            quotient.add(dividend.divide(divisor));
            rest.add(dividend.mod(divisor));
            BigInteger lastQuotient = quotient.get(quotient.size()-1);
            s.add(s.get(s.size()-2).subtract(lastQuotient.multiply(s.get(s.size()-1))));
            t.add(t.get(t.size()-2).subtract(lastQuotient.multiply(t.get(t.size()-1))));

            // Rest of division is new divisor.
            BigInteger oldCryptionKey = divisor;
            divisor = dividend.mod(divisor);
            dividend = oldCryptionKey;
        }
        BigInteger decryptionKey = t.get(t.size()-1);
        if(decryptionKey.signum() == -1) {
            decryptionKey = phiN.add(decryptionKey);
        }
        return decryptionKey;
    }
}
