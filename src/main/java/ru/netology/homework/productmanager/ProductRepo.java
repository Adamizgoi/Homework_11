package ru.netology.homework.productmanager;

public class ProductRepo {
    Product[] repo = new Product[0];

    public void save(Product newProduct) {
        if (findById(newProduct.getId()) != null) {
            throw new AlreadyExistsException(
                    "Element with id: " + newProduct.getId() + " already exist"
            );
        }
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
        if (findById(id) == null) {
            throw new NotFoundException(
                    "Element with id: " + id + " not found"
            );
        }
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

    public Product findById(int id) {
        for (Product someProduct : repo) {
            if (someProduct.getId() == id) {
                return someProduct;
            }
        }
        return null;
    }

    public Product[] showAll() {
        return repo;
    }
}
