package lab6;

import java.util.Scanner;

public class Lab6_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int answer = 0;
        for (int i = a; i <= b; i++) {
            answer += i;
        }
        System.out.println(answer);
    }
}
