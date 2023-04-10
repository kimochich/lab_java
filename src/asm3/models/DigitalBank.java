package asm3.models;

import asm2.models.Bank;
import asm2.models.Customer;

public class DigitalBank extends Bank {

    public Customer getCustomerById(String customerId) {
        for (Customer customer : getCustomers()) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }

    public void addCustomer(String customerId, String name) throws Exception {
        DigitalCustomer customer = new DigitalCustomer();
        customer.setCustomerId(customerId);
        customer.setName(name);
        addCustomer(customer);
    }

    public void withdraw(String customerId, String accountNumber, double amount) {
        for (Customer customer : getCustomers()) {
            if (customer.getCustomerId().equals(customerId)) {
                DigitalCustomer digitalCustomer = (DigitalCustomer) customer;
                digitalCustomer.withdraw(accountNumber, amount);
            }
        }
    }


}
