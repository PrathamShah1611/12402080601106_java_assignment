import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InvestmentCalculator extends JFrame implements ActionListener {

    JTextField t1, t2, t3, t4;
    JButton btn;

    InvestmentCalculator() {
        setTitle("Investment Calculator");

        JLabel l1 = new JLabel("Principal:");
        JLabel l2 = new JLabel("Rate (%):");
        JLabel l3 = new JLabel("Time (years):");
        JLabel l4 = new JLabel("Amount:");

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t4.setEditable(false);

        btn = new JButton("Calculate");
        btn.addActionListener(this);

        setLayout(new GridLayout(5, 2, 10, 10));

        add(l1); add(t1);
        add(l2); add(t2);
        add(l3); add(t3);
        add(l4); add(t4);
        add(new JLabel()); add(btn);

        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double p = Double.parseDouble(t1.getText());
            double r = Double.parseDouble(t2.getText());
            double t = Double.parseDouble(t3.getText());

            double amount = p + (p * r * t / 100); // Simple Interest

            t4.setText(String.valueOf(amount));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Enter valid numbers");
        }
    }

    public static void main(String[] args) {
        new InvestmentCalculator();
    }
}
