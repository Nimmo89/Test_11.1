package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.*;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
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
        manager.add(b1);
        manager.add(b2);
        manager.add(b3);
        manager.add(b4);
        manager.add(b5);
        manager.add(s1);
        manager.add(s2);
        manager.add(s3);
        manager.add(s4);
        manager.add(s5);
    }

    @Test
    void searchByAutor() {
        Book[] expected = new Book[]{b1, b5};
        Product[] actual = manager.searchBy("Au1");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByNameBook() {
        Book[] expected = new Book[]{b3};
        Product[] actual = manager.searchBy("Book3");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByNameSmartphone() {
        Smartphone[] expected = new Smartphone[]{s4};
        Product[] actual = manager.searchBy("Smart4");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByProducer() {
        Smartphone[] expected = new Smartphone[]{s1, s5};
        Product[] actual = manager.searchBy("Sm1");
        assertArrayEquals(expected, actual);
    }
}