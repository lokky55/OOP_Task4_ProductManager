package ru.netology;

public class Repository {

    private Product[] products = new Product[0];  // "приватное поле products типа(класса) Product = новый объект с кол-во элементов массива 0"

    public void add(Product product) {  // метод сохранения (добавления) продукта
        Product[] tmp = new Product[products.length + 1];
        System.arraycopy(products, 0, tmp, 0, products.length);
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

//    // тот же метод сохранения "продуктов" через цикл
//    public void save(Product product) {
//        Product[] tmp = new Product[products.length + 1];
//        for (int i = 0; i < products.length; i++) {
//            tmp[i] = products[i];
//        }
//        tmp[tmp.length - 1] = product;
//        products = tmp;
//    }

    public Product[] findAll() {
        return products;
    }  // Product[] - тип возвращаемого результата

    public Product findById(int id) {
        for (Product product : findAll()) {   // findAll() получение всех элементов, которые будем перебирать
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void removeById(int id) {      // метод удаления по id
        if (findById(id) == null) {
            throw new NotFoundException("Введен несуществующий id: " + id);
        }
        Product[] tmp = new Product[products.length - 1];
        int index = 0;
        for (Product product : products) {    // используем for each
            if (product.getId() != id) {      // стандартный геттер поля id
                tmp[index] = product;
                index++;
            }
        }
        products = tmp;
    }


}
