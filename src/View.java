import javax.swing.*;
import java.awt.*;

public class View {
    private JFrame frame;
    private JButton cancel;
    private JButton encrypt;
    private JTextField input;
    private JTextField output;

    public View(String title) {
        frame = new JFrame(title);
        frame.getContentPane().setLayout(new GridLayout(2,2));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);

        cancel = new JButton("Cancel");
        input = new JTextField();
        input.setToolTipText("input");
        encrypt = new JButton("Encrypt");
        output = new JTextField();
        output.setEnabled(false);
        frame.add(cancel);
        frame.add(input);
        frame.add(encrypt);
        frame.add(output);

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
}
