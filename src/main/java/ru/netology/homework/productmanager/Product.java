package ru.netology.homework.productmanager;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
public class Product {
    protected int id;
    @NonNull protected String name;
    protected double price;
}
