package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    private Repository repo = new Repository();
    private ProductManager manager = new ProductManager(repo);

    private Book book = new Book(1, "Idiot", 500, "Dostoevsky");
    private Book book1 = new Book(2, "Master & Margarita", 600, "Bulgakov");

    private Smartphone tel = new Smartphone(3, "Boxer", 5000, "Nokia");
    private Smartphone tel1 = new Smartphone(4, "Galaxy", 13000, "Samsung");

    @BeforeEach
    public void setUp() {
        manager.add(book);
        manager.add(book1);
        manager.add(tel);
        manager.add(tel1);
    }

    @Test
    public void shouldAddProduct() {
        manager.add(book);
        Product[] actual = repo.findAll();
        Product[] expected = {book, book1, tel, tel1, book};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        manager.removeById(1);
        Product[] actual = repo.findAll();
        Product[] expected = {book1, tel, tel1};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchProductByName() {
        Product[] actual = manager.searchBy("Idiot");
        Product[] expected = {book};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchOneByTextInName() {
        Product[] actual = manager.searchBy("gar");
        Product[] expected = {book1};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNoProduct() {
        Product[] actual = manager.searchBy("aaa");
        Product[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSeveralProducts() {
        Product[] actual = manager.searchBy("er");
        Product[] expected = {book1, tel};
        Assertions.assertArrayEquals(expected, actual);
    }
}
