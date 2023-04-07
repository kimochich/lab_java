package asm3;

import java.util.Scanner;

public class Asm03 {

    final static String PROJECT_NAME = "NGAN HANG SO";
    final static String STUDENT_CODE = "xM02173";
    final static String VERSION = "v3.0.0";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        boolean willContinue = true;
        do {
            System.out.println("+-----+-------------------+------+");
            System.out.println("| " + PROJECT_NAME + " | " + STUDENT_CODE + "@" + VERSION + "  |");
            System.out.println("+-----+-------------------+------+");
            System.out.println("1. Thong tin khach hang");
            System.out.println("2. Them tai khoan ATM");
            System.out.println("3. Them tai khoan tin dung");
            System.out.println("4. Rut tien");
            System.out.println("5. Lich su giao dich");
            System.out.println("0. Thoat");
            System.out.println("+-----+-------------------+------+");
            System.out.print("Chuc nang: ");
            n = Integer.parseInt(sc.nextLine());
            //nhập lại nếu số nhập vào không nằm trong menu
            while (n < 0 || n > 5) {
                System.out.println("Khong hop le, vui long nhap lai");
                n = Integer.parseInt(sc.nextLine());
            }
            switch (n) {
                case 1:

                    break;

            }
        } while (willContinue);

    }
}
