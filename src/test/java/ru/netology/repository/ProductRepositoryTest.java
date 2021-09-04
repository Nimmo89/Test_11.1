package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import java.util.ArrayList;
import java.util.Collection;

//import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repo = new ProductRepository();

    @Test
    void addAllProd() {
        Collection<Product> products = new ArrayList<>();
        products.add(new Product());
        products.add(new Product());
        products.add(new Product());
        products.add(new Product());

        repo.saveAll(products);
        System.out.println(repo.findAll().size());
    }

    @Test
    void addAllSmart() {
        Collection<Smartphone> products = new ArrayList<>();
        products.add(new Smartphone());
        products.add(new Smartphone());
        products.add(new Smartphone());

        repo.saveAll(products);
        System.out.println(repo.findAll().size());
    }

}