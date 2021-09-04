package ru.netology.repository;

import ru.netology.domain.*;

import java.util.ArrayList;
import java.util.Collection;

public class ProductRepository {
    private Collection<Product> products = new ArrayList<>();

    public boolean save(Product item) {
        return products.add(item);
    }

    public void saveAll(Collection<Product> products) {
        this.products.addAll(products);
    }

    public Collection<Product> findAll() {
        return products;
    }

    public Product[] findById(int id) {
        for (Product item : products) {
            if (item.getId() == id) {
                return new Product[]{item};
            }
        }
        return null;
    }

    public void removeById(int id) {
        products.removeIf(product -> product.getId() == id);
    }

    public void removeAll(Collection<Product> products) {
        this.products.removeAll(products);
    }

    public ProductRepository() {
    }
}