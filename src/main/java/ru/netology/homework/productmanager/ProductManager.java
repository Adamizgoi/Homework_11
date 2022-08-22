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
        Product[] result = new Product[0];
        for (Product someProduct : repo.showAll()) {
            if(matches(text, someProduct)) {
                Product[] tmp = new Product[result.length + 1];
                tmp[tmp.length - 1] = someProduct;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(String text, Product someProduct) {
        return someProduct.getName().contains(text);
    }

    public Product[] showAll() {
        return repo.showAll();
    }
}
