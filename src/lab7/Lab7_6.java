package lab7;

import java.util.Scanner;

public class Lab7_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i : arr) {
            System.out.print(i % 2 == 0 ? i + " " : "");
        }
    }
}
