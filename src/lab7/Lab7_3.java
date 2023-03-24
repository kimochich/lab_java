package lab7;

import java.util.Scanner;

public class Lab7_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i: arr) {
            System.out.print(i+" ");
        }
    }
}
