package ru.netology.homework.productmanager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepoTest {

    Product book1 = new Book(1, "Анна Каренина", 100.5, "Лев Толстой");
    Product smartphone1 = new Smartphone(2, "Nokia 15 ProSmart", 5500, "Nokia");
    Product product1 = new Product(3, "Детская игрушка", 312);

    ProductRepo repo = new ProductRepo();

    @Test
    public void shouldRemoveById() {
        repo.save(book1);
        repo.save(smartphone1);
        repo.removeById(1);

        Product[] expected = {smartphone1};
        Product[] actual = repo.showAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTrowRightExceptionInRemoveByUnknownId() {
        repo.save(book1);
        repo.save(smartphone1);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(80);
        });
    }

    @Test
    public void shouldSaveProduct() {
        repo.save(product1);

        Product[] expected = {product1};
        Product[] actual = repo.showAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
