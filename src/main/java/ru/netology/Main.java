package ru.netology;

// проверяем вывод сообщения выпадающего исключения

public class Main {
    public static void main(String[] args) {

        Repository repo = new Repository();
        Book book = new Book(1, "Idiot", 500, "Dostoevsky");
        Book book1 = new Book(2, "Master & Margarita", 600, "Bulgakov");
        Smartphone tel = new Smartphone(4, "N100", 5000, "Nokia");
        Smartphone tel1 = new Smartphone(5, "Galaxy", 13000, "Samsung");

        repo.add(book);
        repo.add(book1);
        repo.add(tel);
        repo.add(tel1);

        repo.removeById(3);
        System.out.println("Удаление произведено успешно");
    }
}
