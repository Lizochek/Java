/*package lab10;
import java.awt.*;
import java.awt.event.*;
import java.util.Locale;
import javax.swing.*;

public class Application {
    public static void main(String[] args) {


        AplFrame frame = new AplFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(500, 500);


    }
}
     class AplFrame extends JFrame {
        public AplFrame() {
            setTitle("Application");
            AplPanel panel = new AplPanel();
            add(panel);
            pack();
        }

        }


    class AplPanel extends JPanel {
    public AplPanel() {
        setLayout(new BorderLayout());

        JTextField firstValue = new JTextField();
        JTextField secondValue = new JTextField();
        JLabel Result = new JLabel();

        ActionListener command = new CommandAction();

        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        addButton("+", command);
        addButton("-", command);
        addButton("*", command);
        addButton("/", command);


        add(panel, BorderLayout.CENTER);


    }
        private void addButton(String label, ActionListener listener) {
            JButton button = new JButton(label);
            button.addActionListener(listener);
            panel.add(button);
        }
        private class CommandAction implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                String command = event.getActionCommand();
                if(start)
                {
                    if(command.equals("-"))
                    {
                        display.setText(command);
                        start = false;
                    }
                    else lastCommand = command;
                }
                else
                {
                    calculate(Double.parseDouble(display.getText()));
                    lastCommand = command;
                    start=true;
                }
            }
        }
        public void calculate(double x)
        {

        }
        switch () {
                    case "+":
                        result = firstOperand + secondOperand;
                        break;
                    case "-":
                        result = firstOperand - secondOperand;
                        break;
                    case "*":
                        result = firstOperand * secondOperand;
                        break;
                    case "/":
                        if(secondOperand != 0)
                            result = firstOperand / secondOperand;
                        break;
                    default:
                        lResult.setText("Undefined operation!");
                        break;
                }
                if(Double.isNaN(result)){
                    Result.setText("Disallowed operation!");
                } else{
                    int digit;
                    String size = "%.0f";
                    for(digit = 4; digit > 0; digit--){
                        if(Math.round(result * Math.pow(10, digit)) % 10 != 0){
                            size = "%." + digit + "f";
                            break;
                        }
                    }
                    Result.setText(String.format(Locale.US, size, result));
                }
            }else {
            Result.setText("Invalid operand!");
        }
        }
                }
                }
            }
        }

    private void addButton(String label, ActionListener listener) {
        JButton button = new JButton(label);
        button.addActionListener(listener);
        panel.add(button);
    }

        private JButton display;
        private JPanel panel;
        private boolean start;


*/