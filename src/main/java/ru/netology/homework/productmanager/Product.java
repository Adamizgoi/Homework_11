package ru.netology.homework.productmanager;

import lombok.*;

@AllArgsConstructor
public class Product {
    protected int id;
    @NonNull
    protected String name;
    protected double price;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean matches(String search) {
        if (getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
