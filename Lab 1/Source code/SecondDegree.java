import java.util.*;

public class SecondDegree {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        double a, b, c;
        do {
            System.out.println("Please enter a , b and c, where a is not equal to 0 :");
            a = inp.nextDouble();
            b = inp.nextDouble();
            c = inp.nextDouble();
        } while (a == 0);

        double delta = b * b - 4 * a * c;

        if (delta > 0) {
            double d = Math.sqrt(b * b - 4 * a * c);
            double x1 = (-b + d) / (2 * a), x2 = (-b - d) / (2 * a);

            System.out.println("The equation has two distinct roots :\nx1 = " + x1 + "\nx2 = " + x2);
        } else if (delta == 0)
            System.out.println("The equation has a double root :\nx = " + (-b / 2 * a));
        else
            System.out.println("The equation has no root !");

        inp.close();
    }
}