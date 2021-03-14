package ru.netology.domain;

import lombok.Data;
@Data

public class Smartphone extends Product{
    private String label;

    public Smartphone(int id, String name, int price, String label) {
        super(id, name, price);
        this.label = label;
    }
}
