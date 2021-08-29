package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.*;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book b1 = new Book(1, "Book1", 200, "Au1");
    private Book b2 = new Book(2, "Book2", 300, "Au2");
    private Book b3 = new Book(3, "Book3", 150, "Au3");
    private Book b4 = new Book(4, "Book4", 450, "Au2");
    private Book b5 = new Book(5, "Book5", 500, "Au1");
    private Smartphone s1 = new Smartphone(1, "Smart1", 2000, "Sm1");
    private Smartphone s2 = new Smartphone(2, "Smart2", 5000, "Sm2");
    private Smartphone s3 = new Smartphone(3, "Smart3", 7500, "Sm3");
    private Smartphone s4 = new Smartphone(4, "Smart4", 9000, "Sm4");
    private Smartphone s5 = new Smartphone(5, "Smart5", 20000, "Sm1");

    @BeforeEach
    void setUP(){
        repository.save(b1);
        repository.save(b2);
        repository.save(b3);
        repository.save(s4);
        repository.save(s5);
    }

    @Test
    void removeById() {
        repository.removeById(3);
        Product[] expected = new Product[]{b1, b2, s4, s5};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void idNotFound() {
        assertThrows(NotFoundException.class, () -> repository.removeById(0));
    }
}