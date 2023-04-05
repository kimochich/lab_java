package asm2;

import asm2.models.Account;
import asm2.models.Bank;
import asm2.models.Customer;

import java.util.Scanner;

public class Asm02 {
    final static String PROJECT_NAME = "NGAN HANG SO";
    final static String STUDENT_CODE = "xM02173";
    final static String VERSION = "v2.0.0";
    private static final Bank bank = new Bank();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        boolean willContinue = true;
        do {
            try {
                System.out.println("+-----+-------------------+------+");
                System.out.println("| " + PROJECT_NAME + " | " + STUDENT_CODE + "@" + VERSION + "  |");
                System.out.println("+-----+-------------------+------+");
                System.out.println("| 1. Them khach hang                           |");
                System.out.println("| 2. Them tai khoan cho khach hang             |");
                System.out.println("| 3. Hien thi danh sach khach hang             |");
                System.out.println("| 4. Tim theo CCCD                             |");
                System.out.println("| 5. Tim theo ten khach hang                   |");
                System.out.println("| 0. Thoat                                     |");
                System.out.print("Chuc nang: ");
                n = Integer.parseInt(sc.nextLine());
                //nhập lại nếu số nhập vào không nằm trong menu
                while (n < 0 || n > 5) {
                    System.out.println("Khong hop le, vui long nhap lai");
                    n = sc.nextInt();
                }
                switch (n) {
                    case 1:
                        inputCustomer(sc);
                        break;
                    case 2:
                        inputAccount(sc);
                        break;
                    case 3:
                        showCustomerList();
                        break;
                    case 4:
                        searchCustomerByCCCD(sc);
                        break;
                    case 5:
                        searchCustomerByName(sc);
                        break;
                    case 0:
                        willContinue = false;
                        exit();
                        break;
                }

            } catch (Exception e) {
                System.out.println("Khong hop le,vui long nhap lai");
            }
        } while (willContinue); // lặp lại cho đến khi số nhập vào hợp lệ
    }

    private static void searchCustomerByName(Scanner sc) {
        System.out.println("Nhap ten khach hang:");
        String name = sc.nextLine();
        for (Customer cus : bank.getCustomers()) {
            if (cus.getName().trim().contains(name.trim())) {
                cus.displayInformation();
            }
        }
    }

    private static void searchCustomerByCCCD(Scanner sc) {
        System.out.println("Nhap CCCD khach hang:");
        String cccd = sc.nextLine();
        while (!cccd.matches("[0-9]{12}")) {
            System.out.println("So CCCD khong hop le. Vui long nhap lai");
            cccd = sc.nextLine();
        }
        for (Customer cus : bank.getCustomers()) {
            if (cus.getCustomerId().equals(cccd)) {
                cus.displayInformation();
            }
        }
    }

    private static void showCustomerList() {
        for (Customer cus : bank.getCustomers()) {
            cus.displayInformation();
        }
    }

    private static void inputAccount(Scanner sc) {
        Account acc = new Account();
        System.out.println("Nhap CCCD khach hang:");
        String cccd = sc.nextLine();
        while (!cccd.matches("[0-9]{12}")) {
            System.out.println("So CCCD khong hop le. Vui long nhap lai");
            cccd = sc.nextLine();
        }
        System.out.println("Nhap ma STK gom 6 chu so:");
        String accountNumber = sc.nextLine();
        //kiểm tra số tài khoản có tồn tại trong bank và số tk hợp lệ
        while (accountNumber.length() != 6 || bank.existAccountNumber(accountNumber)) {
            System.out.println("STK khong hop le hoac da trung lap trong he thong, vui long nhap lai");
            accountNumber = sc.nextLine();
        }
        acc.setAccountNumber(accountNumber);
        System.out.println("Nhap so du:");
        double balance = Double.parseDouble(sc.nextLine());
        while (balance < 50000) {
            System.out.println("So du khong duoc nho hon 50_000 VND, vui long nhap lai");
            balance = Double.parseDouble(sc.nextLine());
        }
        acc.setBalance(balance);
        bank.addAccount(cccd, acc);
    }

    private static void inputCustomer(Scanner sc) {
        try {
            Customer customer = new Customer();
            System.out.println("Nhap ten khach hang:");
            customer.setName(sc.nextLine());
            System.out.println("Nhap so CCCD:");
            customer.setCustomerId(sc.nextLine());
            bank.addCustomer(customer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }


    //thoát chương trình
    public static void exit() {
        System.out.println("Chuong trinh da dung lai");
        System.exit(0);
    }
}
