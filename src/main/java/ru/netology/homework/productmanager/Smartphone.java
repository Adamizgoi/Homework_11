package ru.netology.homework.productmanager;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class Smartphone extends Product {
    private String company;

    public Smartphone(int id, String name, double price, String company) {
        super(id, name, price);
        this.company = company;
    }
}
