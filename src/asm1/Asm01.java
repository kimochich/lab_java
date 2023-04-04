package asm1;

import java.util.Random;
import java.util.Scanner;

public class Asm01 {

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
        System.out.println("| " + PROJECT_NAME + " | " + STUDENT_CODE + "@" + VERSION + "  |");
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
        System.out.println("So ngau nhien: " + code);
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
            case "012":
                province = "Lai Chau";
                break;
            case "014":
                province = "Son La";
                break;
            case "015":
                province = "Yen Bai";
                break;
            case "017":
                province = "Hoa Binh";
                break;
            case "019":
                province = "Thai Nguyen";
                break;
            case "020":
                province = "Lang Son";
                break;
            case "022":
                province = "Quang Ninh";
                break;
            case "024":
                province = "Bac giang";
                break;
            case "025":
                province = "Phu Tho";
                break;
            case "026":
                province = "Vinh Phuc";
                break;
            case "027":
                province = "Bac Ninh";
                break;
            case "030":
                province = "Hai Duong";
                break;
            case "031":
                province = "Hai Phong";
                break;
            case "033":
                province = "Hung Yen";
                break;
            case "034":
                province = "Thai Binh";
                break;
            case "035":
                province = "Ha Nam";
                break;
            case "036":
                province = "Nam Dinh";
                break;
            case "037":
                province = "Ninh Binh";
                break;
            case "038":
                province = "Thanh Hoa";
                break;
            case "040":
                province = "Nghe An";
                break;
            case "042":
                province = "Ha Tinh";
                break;
            case "044":
                province = "Quang Binh";
                break;
            case "045":
                province = "Quang Tri";
                break;
            case "046":
                province = "Thua Thien Hue";
                break;
            case "048":
                province = "Da nang";
                break;
            case "049":
                province = "Quang Nam";
                break;
            case "051":
                province = "Quang Ngai";
                break;
            case "052":
                province = "Binh Dinh";
                break;
            case "054":
                province = "Phu Yen";
                break;
            case "056":
                province = "Khanh Hoa";
                break;
            case "058":
                province = "Ninh Thuan";
                break;
            case "060":
                province = "Binh Thuan";
                break;
            case "062":
                province = "Kon Tum";
                break;
            case "064":
                province = "Gia Lai";
                break;
            case "066":
                province = "Dak lak";
                break;
            case "067":
                province = "Dak Nong";
                break;
            case "068":
                province = "Lam Dong";
                break;
            case "070":
                province = "Binh Phuong";
                break;
            case "072":
                province = "Tay Ninh";
                break;
            case "074":
                province = "Binh Duong";
                break;
            case "075":
                province = "Dong Nai";
                break;
            case "077":
                province = "Ba Ria - Vung Tau";
                break;
            case "079":
                province = "Ho Chi Minh";
                break;
            case "080":
                province = "Long An";
                break;
            case "082":
                province = "Tien Giang";
                break;
            case "083":
                province = "Ben Tre";
                break;
            case "084":
                province = "Tra Vinh";
                break;
            case "086":
                province = "Vinh Long";
                break;
            case "087":
                province = "Dong Thap";
                break;
            case "089":
                province = "An Giang";
                break;
            case "091":
                province = "Kien Giang";
                break;
            case "092":
                province = "Can Tho";
                break;
            case "093":
                province = "Hau Giang";
                break;
            case "094":
                province = "Soc Trang";
                break;
            case "095":
                province = "Bac Lieu";
                break;
            case "096":
                province = "Ca Mau";
                break;
            default:
                province = "Khong xac dinh";
                break;
        }
        System.out.println("Noi sinh: " + province);
    }

}
