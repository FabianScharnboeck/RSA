import javax.swing.*;
import java.awt.*;

public class View {
    private JFrame frame;
    private JButton cancel;
    private JButton encrypt;
    private JTextField input;
    private JTextField output;
    private JButton decrypt;
    private JTextField decryptedOutput;

    public View(String title) {
        frame = new JFrame(title);
        frame.getContentPane().setLayout(new GridLayout(3,3));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);

        cancel = new JButton("Cancel");
        input = new JTextField();
        input.setToolTipText("input");
        encrypt = new JButton("Encrypt");
        output = new JTextField();
        output.setEditable(false);
        decrypt = new JButton("Decrypt");
        decryptedOutput = new JTextField();
        decryptedOutput.setEditable(false);
        frame.add(cancel);
        frame.add(input);
        frame.add(encrypt);
        frame.add(output);
        frame.add(decrypt);
        frame.add(decryptedOutput);

        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JButton getCancel() {
        return cancel;
    }

    public void setCancel(JButton cancel) {
        this.cancel = cancel;
    }

    public JButton getEncrypt() {
        return encrypt;
    }

    public void setEncrypt(JButton encrypt) {
        this.encrypt = encrypt;
    }

    public JTextField getInput() {
        return input;
    }

    public void setInput(JTextField input) {
        this.input = input;
    }

    public JTextField getOutput() {
        return output;
    }

    public void setOutput(JTextField output) {
        this.output = output;
    }

    public JButton getDecrypt() {
        return decrypt;
    }

    public void setDecrypt(JButton decrypt) {
        this.decrypt = decrypt;
    }

    public JTextField getDecryptedOutput() {
        return decryptedOutput;
    }

    public void setDecryptedOutput(JTextField decryptedOutput) {
        this.decryptedOutput = decryptedOutput;
    }
}
