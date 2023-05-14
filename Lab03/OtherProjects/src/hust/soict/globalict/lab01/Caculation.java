package hust.soict.globalict.lab01;

import javax.swing.JOptionPane;

public class Caculation {
    public static void main(String[] args) {
        String strNum1, strNum2;
        Double num1, num2;

        strNum1 = JOptionPane.showInputDialog("Enter the first number:");
        num1 = Double.parseDouble(strNum1);

        strNum2 = JOptionPane.showInputDialog("Enter the second number:");
        num2 = Double.parseDouble(strNum2);

        String disp = "For the two entered numbers:\n";
        disp += "The sum is " + (num1 + num2) + "\n";
        disp += "The difference is " + (num1 - num2) + "\n";
        disp += "The product is " + (num1 * num2) + "\n";
        if (num2 != 0)
            disp += "The quotient is " + (num1 / num2);
        else
            disp += "Can not divide by 0 !";

        JOptionPane.showMessageDialog(null, disp);
    }
}
