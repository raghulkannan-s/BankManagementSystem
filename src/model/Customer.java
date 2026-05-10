package model;

import util.idGenerator;

public class Customer {

    private int customerId;
    private String name;
    private int age;
    private String mobile;
    private String email;
    private String address;

    public Customer(
            String name,
            int age,
            String mobile,
            String email,
            String address
    ) {

        this.name = name;
        this.age = age;
        this.mobile = mobile;
        this.email = email;
        this.address = address;

    }

    public int getCustomerId() {
        return customerId;
    }

    public void generateCustomerId() {
        this.customerId = idGenerator.generateId();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {

        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}