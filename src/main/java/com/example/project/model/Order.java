package com.example.project.model;

public class Order {
    private String name;
    private String phone;
    private String email;
    private boolean billBySomeoneElse;

    public Order(String name, String phone, String email, boolean billBySomeoneElse) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.billBySomeoneElse = billBySomeoneElse;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public boolean isBillBySomeoneElse() {
        return billBySomeoneElse;
    }
}
