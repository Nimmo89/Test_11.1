package ru.netology.repository;

import ru.netology.domain.*;

public class ProductRepository {
    private Product[] products = new Product[0];

    public void save(Product item) {
        Product[] tmp = new Product[products.length + 1];
//        System.arraycopy(products, 0, tmp, 0, products.length);
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = item;
        products = tmp;
    }

    public Product[] findAll() {
        return products;
    }

//    public static Product[] findById(int id) {
//        for (Product item : products) {
//            if (item.getId() == id) {
//                return new Product[]{item};
//            }
//        }
//        return null;
//    }
//
//    public static void removeById(int id) {
//        int length = products.length - 1;
//        Product[] tmp = new Product[length];
//        int index = 0;
//        for (Product item : products) {
//            if (item.getId() != id) {
//                tmp[index] = item;
//                index++;
//            }
//        }
//        products = tmp;
//    }

    public ProductRepository() {
    }
}