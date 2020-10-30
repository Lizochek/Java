package oldschool.lab10;

import java.awt.*;
import java.awt.event.*;
import java.util.Locale;
import javax.swing.*;

public class Application {
    public static void main(String[] args) {


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setTitle("Application");
        JPanel panel = getButtonPanel();
        frame.add(panel);
        frame.setSize(500, 500);
        frame.pack();

        frame.setVisible(true);
    }

    private static JPanel getButtonPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JTextField firstValue = new JTextField();
        JTextField secondValue = new JTextField();
        JLabel result = new JLabel("Ответ");

        ActionListener command = new CommandAction(firstValue, secondValue, result);

        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(1, 4));

        addButton("+", command, gridPanel);
        addButton("-", command, gridPanel);
        addButton("*", command, gridPanel);
        addButton("/", command, gridPanel);

        panel.add(firstValue);
        panel.add(gridPanel);
        panel.add(secondValue);
        panel.add(result);
        panel.setSize(400,400);
        return panel;

    }

    private static void addButton(String label, ActionListener listener, JPanel panel) {
        JButton button = new JButton(label);
        button.addActionListener(listener);
        panel.add(button);
    }
}

class CommandAction implements ActionListener {
    private JTextField firstField;
    private JTextField secondField;
    private JLabel resultField;

    public CommandAction(JTextField a, JTextField b, JLabel c) {
        firstField = a;
        secondField = b;
        resultField = c;
    }

    public void actionPerformed(ActionEvent event) {
        double firstText, secondText, result = 0;
        try {

            firstText = Double.parseDouble(firstField.getText());
            secondText = Double.parseDouble(secondField.getText());

            switch (((JButton) (event.getSource())).getText()) {
                case "+":
                    result = firstText + secondText;
                    break;
                case "-":
                    result = firstText - secondText;
                    break;
                case "*":
                    result = firstText * secondText;
                    break;
                case "/":
                    if (secondText != 0) {
                        result = firstText / secondText;
                        break;
                    }
                default:
                    resultField.setText("Undefined operation!");
                    return;
            }
            if (Double.isNaN(result)) {
                resultField.setText("Disallowed operation!");
            } else {


                resultField.setText(String.format(Locale.US, "%.4f", result));
            }

        } catch (NumberFormatException ex) {
            resultField.setText("Invalid operand!");
        }
    }

}