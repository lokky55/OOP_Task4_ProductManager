package ru.netology;

import com.sun.nio.sctp.PeerAddressChangeNotification;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor

public class Product {  // объект этого класса описывает один продукт

    protected int id;
    protected String name;
    protected int cost;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Product(int id, String name, int cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

}
