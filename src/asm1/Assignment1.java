package asm1;

import java.util.Random;
import java.util.Scanner;

public class Assignment1 {

    //  MODE_HARD = true tạo chuỗi 6 số bảo mật ngẫu nhiên
    //  false tạo tạo chuỗi 3 số bảo mật từ 100->999
    final static boolean MODE_HARD = false;
    final static String PROJECT_NAME = "NGAN HANG SO";
    final static String STUDENT_CODE = "xM02173";
    final static String VERSION = "v1.0.0";

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("+-----+-------------------+------+");
        System.out.println("| "+PROJECT_NAME+" | "+STUDENT_CODE+"@"+VERSION+"  |");
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

    public static String randomKey() {
        if (MODE_HARD) {
            Random random = new Random();
            // khai báo mảng ký tự có thể chứa trong mã bảo mật
            char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
            StringBuilder maBaoMat = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                int index = random.nextInt(chars.length);
                maBaoMat.append(chars[index]);
            }
            return maBaoMat.toString();
        } else {
            return String.valueOf((new Random()).nextInt(900) + 100);
        }
    }

    private static void inputCCCD(Scanner sc) {
        boolean isError;
        String randomKey = randomKey();
        System.out.println("Nhap ma xac thuc: " + randomKey);
        do {
            try {
                String code = sc.nextLine();
                // lặp lại cho đến khi nhập đúng mã xác thực
                while (!code.equals(randomKey)) {
                    System.out.println("Ma xac thuc khong dung.Vui long nhap lai");
                    code = sc.nextLine();
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
                menuChild(sc, cccd);
                isError = false;
            } catch (Exception e) {
                System.out.println("Ma xac thuc khong dung.Vui long nhap lai");
                isError = true;
            }
        } while (isError); // lặp lại cho đến khi số nhập vào hợp lệ
    }

    private static void menuChild(Scanner sc, String cccd) {
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
                while (n < 0 || n > 3) {
                    System.out.println("Khong hop le, vui long nhap lai");
                    n = sc.nextInt();
                }
                switch (n) {
                    case 1:
                        //truyền vào mã tỉnh là 3 chữ số đầu
                        checkPlaceOfBirth(cccd.substring(0, 3));
                        break;
                    case 2:
                        // truyền vào mã giới tính và mã năm sinh
                        checkAge(Integer.parseInt(cccd.substring(3, 4)), Integer.parseInt(cccd.substring(4, 6)));
                        break;
                    case 3:
                        //truyền vào 6 số ngẫu nhiên cuối dùng
                        checkDigit(cccd.substring(6, 12));
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

    private static void checkDigit(String code) {
        System.out.println("So ngau nhien la: " + code);
    }

    private static void checkAge(int gender, int year) {
        int centuryYear = 1900;
        switch (gender) {
            case 2:
            case 3:
                centuryYear = 2000;
                break;
            case 4:
            case 5:
                centuryYear = 2100;
                break;
            case 6:
            case 7:
                centuryYear = 2200;
                break;
            case 8:
            case 9:
                centuryYear = 2300;
                break;
        }
        System.out.println("Gioi tinh: " + (gender % 2 == 0 ? "Nam " : "Nu ") + "| " + (centuryYear + year));
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
            case "011":
                province = "Dien Bien";
                break;
            default:
                province = "Khong xac dinh";
                break;
        }
        System.out.println("Noi sinh: " + province);
    }


}
