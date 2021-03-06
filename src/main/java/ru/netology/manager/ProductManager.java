package ru.netology.manager;

import ru.netology.domain.*;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository;

    public void add(Product product) {
        repository.save(product);
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) { // если в параметре product лежит объект класса Book
            Book book = (Book) product; // положем его в переменную типа Book чтобы пользоваться методами класса Book
            if (book.getAuthor().contains(search)) { // проверим есть ли поисковое слово в данных об авторе
                return true;
            }
            if (book.getName().contains(search)) {
                return true;
            }
            return false;
        }
        if (product instanceof Smartphone) { // если в параметре product лежит объект класса Smartphone
            Smartphone smartphone = (Smartphone) product; // положем его в переменную типа Smartphone чтобы пользоваться методами класса Smartphone
            if (smartphone.getProducer().contains(search)) { // проверим есть ли поисковое слово в данных об производителе
                return true;
            }
            if (smartphone.getName().contains(search)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
//                System.arraycopy(repository, 0, tmp, 0, result.length);
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

}