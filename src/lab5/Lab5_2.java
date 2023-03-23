package lab5;

import java.util.Scanner;

public class Lab5_2 {
    public static double chuVi(double r) {
        return 2 * r * 3.14;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double r = sc.nextDouble();
        System.out.print(chuVi(r));
    }
}
