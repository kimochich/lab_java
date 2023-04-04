package asm2.models;

public abstract class User {
    private String name;
    private String customerId;

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) throws Exception {
        if (!customerId.matches("[0-9]{12}")) {
            throw new Exception("So CCCD khong hop le. Vui long nhap lai");
        }
        this.customerId = customerId;
    }
}
