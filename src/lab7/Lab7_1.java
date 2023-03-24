package lab7;

import java.util.Scanner;

public class Lab7_1 {
    public static void show(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] % 3 == 0 && arr[i] % 5 != 0 ? arr[i] + " " : "");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        show(arr);
    }
}
