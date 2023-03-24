package lab7;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab7_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            arrayList.add(a);
        }
        System.out.println(arrayList.get(0)+arrayList.get(n-1));
    }
}
