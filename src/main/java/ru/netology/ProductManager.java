package ru.netology;

public class ProductManager {

    private Repository repository; // создаем поле типа Repository, которым будем управлять

    public ProductManager(Repository repository) {  // аргументом(экземпляр) будем использовать класс Repository
        this.repository = repository;
    }

    public void add(Product product) {
        repository.add(product);
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
        // или в одну строку:
        // return product.getName().contains(search);
    }

    // метод поиска товаров по запросу text
    public Product[] searchBy(String text) {
        Product[] result = new Product[0];         // тут будем хранить подошедшие запросу продукты 0 - кол-во элементов
        for (Product product : repository.findAll()) {   // findAll() получение всех элементов, которые будем перебирать
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }
    // создадим метод поиска суммы по id продуктов
    public int findSum(int[] ids) {
        int sum = 0;
        for (int id : ids) {
            for (Product product : repository.findAll()) {
                if (product.id == id) {
                    sum += product.cost;
                }
            }
        }
        return sum;
    }

}



