package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RepositoryTest {

    private Repository repo = new Repository();

    private Book book = new Book(1, "Idiot", 500, "Dostoevsky");
    private Book book1 = new Book(2, "Master & Margarita", 600, "Bulgakov");

    private Smartphone tel = new Smartphone(4, "N100", 5000, "Nokia");
    private Smartphone tel1 = new Smartphone(5, "Galaxy", 13000, "Samsung");

    @BeforeEach
    public void setUp() {
        repo.save(book);
        repo.save(tel);
    }

    @Test
    public void shouldSaveProducts() {
        repo.save(book1);
        Product[] actual = repo.findAll();
        Product[] expected = {book, tel, book1};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeById() {
        repo.removeById(1);
        Product[] actual = repo.findAll();
        Product[] expected = {tel};
        Assertions.assertArrayEquals(expected, actual);
    }
}


