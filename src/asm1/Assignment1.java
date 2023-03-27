package asm1;

import java.util.Random;
import java.util.Scanner;

public class Assignment1 {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("+-----+-------------------+------+");
        System.out.println("| NGAN HANG SO | xM02173@v1.0.0  |");
        System.out.println("+-----+-------------------+------+");
        System.out.println("| 1. Nhap CCCD                   |");
        System.out.println("| 0. Thoat                       |");
        int n;
        boolean isError;
        do {
            try {
                System.out.print("Chuc nang: ");
                n = sc.nextInt();
                isError = false;
                while (n < 0 || n > 1) {
                    System.out.println("Khong hop le, vui long nhap lai");
                    n = sc.nextInt();
                }
                switch (n) {
                    case 1:
                        inputCCCD(sc);
                        break;
                    case 0:
                        System.out.println("Chuong trinh da dung lai");
                        System.exit(0);
                        break;
                }
            } catch (Exception e) {
                System.out.println("Vui long nhap so nguyen");
                sc.next(); // xoá dữ liệu nhập sai để nhập lại
                isError = true;
            }
        } while (isError);

    }

    private static void inputCCCD(Scanner sc) {
        boolean isError;
        int radomNum = (new Random()).nextInt(900) + 100;
        System.out.println("Nhap ma xac thuc: " + radomNum);
        do {
            try {
                int code = sc.nextInt();
                while (code != radomNum) {
                    System.out.println("Ma xac thuc khong dung.Vui long nhap lai");
                    code = Integer.parseInt(sc.nextLine());
                }
                System.out.println("Nhap vao CCCD");
                String cccd = sc.nextLine();
                while (cccd.length()<12)
                {
                    System.out.println("CCCD khong hop le vui long nhap lai");
                    cccd = sc.nextLine();
                }
                isError = false;
            } catch (Exception e) {
                System.out.println("Ma xac thuc khong dung.Vui long nhap lai");
                isError = true;
                sc.next();
            }
        } while (isError);
    }





}
