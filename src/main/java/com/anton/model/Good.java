package com.anton.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Goods")
public class Good implements Serializable {
    public int getId() {
        return id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private double price;



    public Good(String name, double price){
        this.name = name;
        this.price = price;
    }
    public Good(){
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " " + price;
    }
}
