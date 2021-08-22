package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ProductManagerTest {
    @Mock
    private ProductRepository repository;
    @InjectMocks
    private ProductManager manager;
    private Book coreJava = new Book(2, "Book2", 400, "Author2");
    private Smartphone first = new Smartphone(1, "Nokia", 5000, "Nokia");
    private Book two  = new Book(1, "Book1", 200, "Author1");

    @Test
    void add() {
    }

    @Test
    void getAll() {
    }

    @Test
    void removeById() {
    }

    @Test
    void matches() {
    }

    @Test
    void searchBy() {
    }
}