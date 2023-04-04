package asm2.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Bank {

    private final String id;
    private final List<Customer> customers;

    public Bank() {
        this.customers = new ArrayList<>();
        this.id = String.valueOf(UUID.randomUUID());
    }

    public String getId() {
        return id;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void addCustomer(Customer newCustomer) {
        // nếu không tồn tại customer mới thêm vào list
        if (!isCustomerExisted(newCustomer.getCustomerId())) {
            customers.add(newCustomer);
        }
    }

    public void addAccount(String customerId, Account account) {
        for (Customer cus : customers) {
            if (cus.getCustomerId().equals(customerId)) {
                cus.addAccounts(account);
            }
        }
    }

    public boolean isCustomerExisted(String customerId) {
        for (Customer customer : customers) {
            if (customerId.equals(customer.getCustomerId())) {
                return true;
            }
        }
        return false;
    }

}
