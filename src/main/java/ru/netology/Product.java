package ru.netology;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {  // объект этого класса описывает один продукт

    protected int id;
    protected String name;
    protected int cost;
}
