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
                n = Integer.parseInt(sc.nextLine());
                //nhập lại nếu số nhập vào không nằm trong menu
                while (n < 0 || n > 1) {
                    System.out.println("Khong hop le, vui long nhap lai");
                    n = sc.nextInt();
                }
                switch (n) {
                    case 1:
                        inputCCCD(sc);
                        break;
                    case 0:
                        exit();
                        break;
                }
                isError = false;
            } catch (Exception e) {
                System.out.println("Khong hop le,vui long nhap lai");
                isError = true;
            }
        } while (isError); // lặp lại cho đến khi số nhập vào hợp lệ

    }

    //thoát chương trình
    public static void exit() {
        System.out.println("Chuong trinh da dung lai");
        System.exit(0);
    }

    private static void inputCCCD(Scanner sc) {
        boolean isError;
        // tạo số random từ 100 - 999
        int radomNum = (new Random()).nextInt(900) + 100;
        System.out.println("Nhap ma xac thuc: " + radomNum);
        do {
            try {
                int code = Integer.parseInt(sc.nextLine());
                // lặp lại cho đến khi nhập đúng mã xác thực
                while (code != radomNum) {
                    System.out.println("Ma xac thuc khong dung.Vui long nhap lai");
                    code = Integer.parseInt(sc.nextLine());
                }
                System.out.println("Nhap vao CCCD");
                String cccd = sc.nextLine();
                while (!cccd.matches("[0-9]{12}")) {
                    System.out.println("So CCCD khong hop le. Vui long nhap lai hoac ‘No’ de thoat:");
                    cccd = sc.nextLine();
                    // nếu nhập 'No' thì thoát chương trình
                    if (cccd.equals("No")) {
                        exit();
                    }
                }
                // hiển thị menu kiểm tra số CCCD
                menuCCCD(sc, cccd);
                isError = false;
            } catch (Exception e) {
                System.out.println("Ma xac thuc khong dung.Vui long nhap lai");
                isError = true;
            }
        } while (isError); // lặp lại cho đến khi số nhập vào hợp lệ
    }

    private static void menuCCCD(Scanner sc, String cccd) {
        boolean willContinue = true;
        do {
            System.out.println("| 1. Kiem tra noi sinh                   |");
            System.out.println("| 2. Kiem tra tuoi,gioi tinh             |");
            System.out.println("| 3. Kiem tra so ngau nhien              |");
            System.out.println("| 0. Thoat                               |");
            int n;
            try {
                System.out.print("Chuc nang: ");
                n = Integer.parseInt(sc.nextLine());
                while (n < 0 || n > 1) {
                    System.out.println("Khong hop le, vui long nhap lai");
                    n = sc.nextInt();
                }
                switch (n) {
                    case 1:
                        checkPlaceOfBirth(cccd.substring(0, 3));
                        break;
                    case 2:
                        checkAge(cccd);
                        break;
                    case 3:
                        checkDigit(cccd);
                        break;
                    case 0:
                        willContinue = false;
                        exit();
                        break;
                }
            } catch (Exception e) {
                System.out.println("Khong hop le,vui long nhap lai");
            }
        } while (willContinue);

    }

    private static void checkDigit(String cccd) {

    }

    private static void checkAge(String cccd) {

    }

    private static void checkPlaceOfBirth(String code) {
        String province;
        switch (code) {
            case "001":
                province = "Ha Noi";
                break;
            case "002":
                province = "Ha Giang";
                break;
            case "004":
                province = "Cao Bang";
                break;
            case "006":
                province = "Bac Kan";
                break;
            case "008":
                province = "Tuyen Quang";
                break;
            case "010":
                province = "Lao Cai";
                break;
        }
    }


}
