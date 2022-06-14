package ru.netology;

public class Smartphone extends Product {

    private String smartphoneProducer;

    public Smartphone(int id, String name, int cost, String telProducer) {
        super(id, name, cost);
        this.smartphoneProducer = telProducer;
    }
}
