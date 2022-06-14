package ru.netology;

public class Book extends Product {

    private String bookAuthor;

    public Book(int id, String name, int cost, String bookAuthor) {
        super(id, name, cost);
        this.bookAuthor = bookAuthor;
    }

}
