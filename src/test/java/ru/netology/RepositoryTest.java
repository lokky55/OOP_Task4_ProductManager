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
    private Smartphone tel2 = new Smartphone(6, "13", 25000, "Apple");

    @BeforeEach
    public void setUp() {
        repo.add(book);
        repo.add(book1);
        repo.add(tel);
        repo.add(tel1);
    }

    @Test
    public void removeById() {  //тест проверяющий успешность удаления существующего элемента
        repo.removeById(1);
        Product[] actual = repo.findAll();
        Product[] expected = {book1, tel, tel1};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findById() {
        Product actual = repo.findById(2);
        Product expected = book1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowNotFoundException() {  // тест генерации NotFoundException при попытке удаления несуществующего элемента
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(-1);
        });
    }

    @Test
    public void shouldAddNewElement() {
        repo.add(tel2);
        Product[] actual = repo.findAll();
        Product[] expected = {book, book1, tel, tel1, tel2};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void tryToAddAlreadyExist() {
        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.isAlreadyExist(1);
        });
    }
}


