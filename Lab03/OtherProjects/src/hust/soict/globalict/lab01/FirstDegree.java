package hust.soict.globalict.lab01;

import java.util.*;

public class FirstDegree {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        double a, b;
        do {
            System.out.println("Please enter a and b, where a is not equal to 0 :");
            a = inp.nextDouble();
            b = inp.nextDouble();
        } while (a == 0);

        System.out.println("The equation has 1 root x = " + (-b / a));

        inp.close();
    }
}
