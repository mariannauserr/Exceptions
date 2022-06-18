package ru.netology.repository;

import ru.netology.domain.Product;
import ru.netology.exception.AlreadyExistsException;
import ru.netology.exception.NotFoundException;
public class ProductRepository {
    private Product[] products = new Product[0];

    public void add(Product product) {
        if (findById(product.getId()) == null) {
            int length = products.length + 1;
            Product[] tmp = new Product[length];
            for (int i = 0; i < products.length; i++) {
                tmp[i] = products[i];
            }
            tmp[tmp.length - 1] = product;
            products = tmp;
        } else {
            throw new AlreadyExistsException("Element with id: " + product + " already exists");
        }
    }

    public Product[] findAll() {
        return products;
    }

    public Product[] findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return new Product[]{product};
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        int length = products.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }
        }
        products = tmp;
    }
}
