package lab6;

import java.util.Scanner;

public class Lab6_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        for (; a <= b; a++) {
            if (a % 3 == 0 && a % 5 == 0) {
                System.out.print(a + " ");
            }
        }
    }
}
