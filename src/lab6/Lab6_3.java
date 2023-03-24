package lab6;

import java.util.Scanner;

public class Lab6_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        for (int i = a; i <= b; i++) {
            System.out.print((i % 3 == 0) ? i + " " : "");
        }
    }
}
