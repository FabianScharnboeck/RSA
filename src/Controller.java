import javax.swing.*;
import java.math.BigInteger;

public class Controller {
    private RSA rsa;
    private View view;

    public Controller(RSA rsa, View view) {
        this.rsa = rsa;
        this.view = view;
    }

    public void initController() {
        view.getEncrypt().addActionListener
                (e -> {
                    try {
                        BigInteger encryptedMessage = rsa.
                                encrypt(BigInteger.valueOf(Long.parseLong(view.getInput().getText())));
                        view.getOutput().setText(String.valueOf(encryptedMessage));
                    } catch (NumberFormatException f) {
                        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "ERROR: " + f);
                    }
                });
        view.getCancel().addActionListener
                (e -> view.getInput().setText(""));
    }
}
