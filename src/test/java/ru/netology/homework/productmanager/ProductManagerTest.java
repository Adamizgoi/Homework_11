package ru.netology.homework.productmanager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    ProductRepo repo = new ProductRepo();
    ProductManager manager = new ProductManager(repo);

    Product book1 = new Book(1, "Анна Каренина", 100.5, "Лев Толстой");
    Product book2error = new Book(1, "Война и мир", 200, "Лев Толстой");
    Product smartphone1 = new Smartphone(2, "Nokia 15 ProSmart", 5500, "Nokia");
    Product smartphone2error = new Smartphone(-1, "Sony Experia 1", 10991, "Sony");

    @Test
    public void shouldSaveProducts() {
        manager.save(book1);

        Product[] expected = {book1};
        Product[] actual = manager.showAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSaveProductsWithEqualId() {
        manager.save(book1);
        manager.save(book2error);

        Product[] expected = {book1};
        Product[] actual = manager.showAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSaveProductWithIdLessZero() {
        manager.save(smartphone2error);

        Product[] expected = {};
        Product[] actual = manager.showAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByFullProductName() {
        manager.save(book1);
        manager.save(smartphone1);

        Product[] expected = {book1};
        Product[] actual = manager.searchBy("Анна Каренина");

        Assertions.assertArrayEquals(expected, actual);
    }
}
