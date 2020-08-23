import javax.swing.*;
import java.math.BigInteger;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                createAndShowGUI();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static  void createAndShowGUI() {
        View view = new View("RSA");
        BigInteger p = BigInteger.probablePrime(64, new Random());
        BigInteger q = BigInteger.probablePrime(64, new Random());
        RSA model = new RSA(p, q);
        Controller c = new Controller(model, view);
        c.initController();
    }
}
