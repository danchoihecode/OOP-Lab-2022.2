package hust.soict.globalict.lab01;

import java.util.*;

public class SystemOfEquation {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        double a, b, c, d, e, f;

        System.out.println("Please enter values of the coefficients :");
        a = inp.nextDouble();
        b = inp.nextDouble();
        c = inp.nextDouble();
        d = inp.nextDouble();
        e = inp.nextDouble();
        f = inp.nextDouble();

        Double D = a * e - b * d, D1 = c * e - b * f, D2 = a * f - c * d;

        if (D != 0) {

            Double x1 = D1 / D, x2 = D2 / D;
            System.out.println("The system has 1 solution:\nx1 = " + x1 + "\nx2 = " + x2);

        } else if (D1 == 0 && D2 == 0)
            System.out.println("The system has infinitely many solutions !");
        else
            System.out.println("The system has no solution !");

        inp.close();
    }
}
