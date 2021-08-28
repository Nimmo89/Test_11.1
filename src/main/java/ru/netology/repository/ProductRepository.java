package ru.netology.repository;

import ru.netology.domain.*;

public class ProductRepository {
    private Product[] products = new Product[0];

    public void save(Product item) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = item;
        products = tmp;
    }

    public Product[] findAll() {
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
        if (findById() != id){
            throw new NotFoundException("Этого товара нет в списке");
        }
        int length = products.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : products) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        products = tmp;
    }

    public ProductRepository() {
    }
}