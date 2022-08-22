package ru.netology.homework.productmanager;

public class ProductRepo {
    Product[] repo = new Product[0];

    public void save(Product newProduct) {
        Product[] tmp = new Product[repo.length + 1];
        int copyToIndex = 0;

        for (Product someProduct : repo) {
            tmp[copyToIndex] = repo[copyToIndex];
            copyToIndex++;
        }
        tmp[tmp.length - 1] = newProduct;
        repo = tmp;
    }

    public void removeById(int id) {
        Product[] tmp = new Product[repo.length - 1];
        int copyToIndex = 0;

        for (Product someProduct : repo) {
            if (id != someProduct.getId()) {
                tmp[copyToIndex] = someProduct;
                copyToIndex++;
            }
        }
        repo = tmp;
    }

    public Product[] showAll() {
        return repo;
    }
}
