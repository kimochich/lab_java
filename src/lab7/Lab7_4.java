package lab7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Lab7_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            arrayList.add(a);
        }
        int max = arrayList.get(0);
        for (Integer i : arrayList) {
            if (max < i) {
                max = i;
            }
        }
        System.out.println(max);
    }
}
