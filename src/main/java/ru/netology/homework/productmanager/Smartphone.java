package ru.netology.homework.productmanager;

public class Smartphone extends Product {
    private String company;

    public Smartphone(int id, String name, double price, String company) {
        super(id, name, price);
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        if (getCompany().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
