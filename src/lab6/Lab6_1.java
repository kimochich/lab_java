package lab6;

import java.util.Scanner;

public class Lab6_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = n; i >= -n; i--) {
            System.out.print(i + " ");
        }
    }
}
