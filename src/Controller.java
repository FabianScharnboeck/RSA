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
                                encrypt(new BigInteger(view.getInput().getText()));
                        view.getOutput().setText(String.valueOf(encryptedMessage));
                    } catch (NumberFormatException f) {
                        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "ERROR: " + f);
                    }
                });
        view.getCancel().addActionListener
                (e -> view.getInput().setText(""));
        view.getDecrypt().addActionListener
                (e -> {
                    BigInteger output = new BigInteger(view.getOutput().getText());
                    BigInteger decryption = rsa.decrypt(output);
                    view.getDecryptedOutput().setText(String.valueOf(decryption));
                });
    }
}
