package asm3;

import asm2.models.Account;
import asm2.models.Customer;
import asm3.models.DigitalBank;
import asm3.models.LoanAccount;
import asm3.models.SavingsAccount;
import asm3.utils.Utils;

import java.util.Scanner;

public class Asm03 {

    final static String PROJECT_NAME = "NGAN HANG SO";
    final static String STUDENT_CODE = "xM02173";
    final static String VERSION = "v3.0.0";
    private static DigitalBank digitalBank = new DigitalBank();
    private static String CUSTOMER_ID = "019098002778";
    private static String CUSTOMER_NAME = "TU";


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        digitalBank.addCustomer(CUSTOMER_ID, CUSTOMER_NAME);
        int n;
        boolean willContinue = true;
        do {
            try {
                System.out.println(Utils.getDivider());
                System.out.println("| " + PROJECT_NAME + " | " + STUDENT_CODE + "@" + VERSION + "  |");
                System.out.println(Utils.getDivider());
                System.out.println("1. Thong tin khach hang");
                System.out.println("2. Them tai khoan Savings");
                System.out.println("3. Them tai khoan Loan");
                System.out.println("4. Rut tien");
                System.out.println("5. Lich su giao dich");
                System.out.println("0. Thoat");
                System.out.println(Utils.getDivider());
                System.out.print("Chuc nang: ");
                n = Integer.parseInt(sc.nextLine());
                //nhập lại nếu số nhập vào không nằm trong menu
                while (n < 0 || n > 5) {
                    System.out.println("Khong hop le, vui long nhap lai");
                    n = Integer.parseInt(sc.nextLine());
                }
                switch (n) {
                    case 1:
                        // hiển thị thông tin khách hàng
                        showCustomer();
                        break;
                    case 2:
                        // thêm tài khoản savings
                        SavingsAccount savingsAccount = new SavingsAccount();
                        inputAccount(sc, savingsAccount);
                        break;
                    case 3:
                        // thêm tài khoản loan
                        LoanAccount loanAccount = new LoanAccount();
                        inputAccount(sc, loanAccount);
                        break;
                    case 4:
                        //rút tiền
                        withdraw(sc, CUSTOMER_ID);
                        break;
                    case 5:
                        //hiển thị lịch sử rút tiền
                        showTransactionList();
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

    private static void showTransactionList() {
        System.out.println(Utils.getDivider());
        System.out.printf("| LICH SU GIAO DICH%13s |\n","");
        System.out.println(Utils.getDivider());
        Customer customer = digitalBank.getCustomerById(CUSTOMER_ID);
        customer.displayTransaction();
        System.out.println(Utils.getDivider());

    }

    private static void withdraw(Scanner sc, String customerId) {
        System.out.println("Nhap ma STK gom 6 chu so:");
        String accountNumber = sc.nextLine();
        //kiểm tra số tài khoản có tồn tại trong bank và số tk hợp lệ
        while (accountNumber.length() != 6 || !digitalBank.existAccountNumber(accountNumber)) {
            System.out.println("STK khong hop le hoac khong ton tai trong he thong, vui long nhap lai");
            accountNumber = sc.nextLine();
        }
        boolean isError;
        double amount = 0;
        do {
            try {
                System.out.println("Nhap so tien rut:");
                amount = Double.parseDouble(sc.nextLine());
                isError = false;
            } catch (Exception e) {
                isError = true;
                System.out.println("So tien hop le, vui long nhap lai");
            }
        } while (isError);
        digitalBank.withdraw(customerId, accountNumber, amount);

    }

    private static void inputAccount(Scanner sc, Account acc) {
        System.out.println("Nhap ma STK gom 6 chu so:");
        String accountNumber = sc.nextLine();
        //kiểm tra số tài khoản có tồn tại trong bank và số tk hợp lệ
        while (accountNumber.length() != 6 || digitalBank.existAccountNumber(accountNumber)) {
            System.out.println("STK khong hop le hoac trung lap trong he thong, vui long nhap lai");
            accountNumber = sc.nextLine();
        }
        acc.setAccountNumber(accountNumber);
        boolean isError;
        double balance = 0;
        do {
            try {
                System.out.println("Nhap so du:");
                balance = Double.parseDouble(sc.nextLine());
                while (balance < 50000) {
                    System.out.println("So du khong duoc nho hon 50_000 VND, vui long nhap lai");
                    balance = Double.parseDouble(sc.nextLine());
                }
                isError = false;
            } catch (Exception e) {
                isError = true;
                System.out.println("So du hop le, vui long nhap lai");
            }
        } while (isError);
        acc.setBalance(balance);
        digitalBank.addAccount(CUSTOMER_ID, acc);
    }

    private static void showCustomer() {
        Customer customer = digitalBank.getCustomerById(CUSTOMER_ID);
        if (customer != null) {
            customer.displayInformation();
        }
    }


    //thoát chương trình
    public static void exit() {
        System.out.println("Chuong trinh da dung lai");
        System.exit(0);
    }
}
