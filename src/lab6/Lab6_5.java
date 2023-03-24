package lab6;

import java.util.Scanner;

public class Lab6_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        n = n % 2 == 1 ? n + 1 : n;
        while(n <= 100) {
            System.out.print(n + " ");
            n += 2;
        }
    }
}
