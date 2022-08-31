package ru.netology.homework.productmanager;

import lombok.Getter;
import lombok.Setter;

public class ProductManager {
    private ProductRepo repo;

    public ProductManager(ProductRepo repo) {
        this.repo = repo;
    }

    public void save(Product newProduct) {
        if (checkSave(newProduct)) {
            repo.save(newProduct);
        }
    }

    public boolean checkSave(Product newProduct) {
        Product[] tmp = repo.showAll();
        for (Product someProduct : tmp) {
            if (someProduct.getId() == newProduct.getId()) {
                return false;
            }
        }
        if (newProduct.getId() < 0) {
            return false;
        }
        return true;
    }

    public Product[] searchBy(String text) {
        Product[] result;
        int resultSize = 0;

        for (Product someProduct : repo.showAll()) {
            if (someProduct.matches(text)) {
                resultSize++;
            }
        }
        result = new Product[resultSize];

        int copyToIndex = 0;
        for (Product someProduct : repo.showAll()) {
            if (someProduct.matches(text)) {
                result[copyToIndex] = someProduct;
                copyToIndex++;
            }
        }
        return result;
    }

    public Product[] showAll() {
        return repo.showAll();
    }
}
