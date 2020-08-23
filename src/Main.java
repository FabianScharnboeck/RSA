import javax.swing.*;
import java.math.BigInteger;

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
        RSA model = new RSA(BigInteger.valueOf(127), BigInteger.valueOf(179));
        Controller c = new Controller(model, view);
        c.initController();
    }
}
