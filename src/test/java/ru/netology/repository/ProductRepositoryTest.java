package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;


class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book coreJava = new Book(2, "Book2", 400, "Author2");
    private Smartphone first = new Smartphone(1, "Nokia", 5000, "Nokia");
    private Book two  = new Book(1, "Book1", 200, "Author1");
    @Test
    void save() {
        repository.save(coreJava);

        Product[] expected = new Product[]{coreJava};
        Product[] actual = ProductRepository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
        repository.findById(1);

        Product[] expected = new Product[]{first};
        Product[] actual = ProductRepository.findById(1);
        assertArrayEquals(expected,actual);
    }

    @Test
    void removeById() {
        int idToRemove = 1;
        ProductRepository.removeById(idToRemove);

        Product[] actual = ProductRepository.findAll();
        Product[] expected = new Product[]{coreJava, two};

        assertArrayEquals(expected, actual);
    }
}