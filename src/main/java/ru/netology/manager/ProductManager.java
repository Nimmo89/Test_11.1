package ru.netology.manager;

import ru.netology.domain.*;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository[] products = new ProductRepository[0];

    public void add(Product product) {
        products.
        int length = products.length + 1; //mew massive + 1
        ProductRepository[] tmp = new ProductRepository[length];
        System.arraycopy(products, 0, tmp, 0, products.length); //copy all elements
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] =;
        products = tmp;
    }

//    public ProductRepository[] getAll() {
//        ProductRepository[] result = new ProductRepository[products.length];
//        for (int i = 0; i < result.length; i++) {
//            int index = products.length - 1 - i;
//            result[i] = products[index];
//        }
//        return result;
//    }
//
//    public void removeById(int id) {
//        int length = products.length - 1;
//        ProductRepository[] tmp = new ProductRepository[length];
//        int index = 0;
//        for (ProductRepository product : products) {
//            if (product.getId() != id) {
//                tmp[index] = product;
//                index++;
//            }
//        }
//        products = tmp;
//    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) { // если в параметре product лежит объект класса Book
            Book book = (Book) product; // положем его в переменную типа Book чтобы пользоваться методами класса Book
            if (book.getAuthor().contains(search)) { // проверим есть ли поисковое слово в данных об авторе
                return true;
            }
            return false;
        }
        if (product instanceof Smartphone) { // если в параметре product лежит объект класса Smartphone
            Smartphone smartphone = (Smartphone) product; // положем его в переменную типа Smartphone чтобы пользоваться методами класса Smartphone
            if (smartphone.getProducer().contains(search)) { // проверим есть ли поисковое слово в данных об производителе
                return true;
            }
            return false;
        }
        return false;
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : ProductRepository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(products, 0, tmp, 0, products.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public ProductManager(ProductRepository[] products) {
        this.products = products;
    }
}